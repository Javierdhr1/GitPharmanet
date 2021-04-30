package com.drogueria.pharmanet.service;

import java.util.Optional;

import javax.naming.AuthenticationException;
import javax.security.auth.login.AccountException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.drogueria.pharmanet.dto.ChangePasswordForm;
import com.drogueria.pharmanet.entity.User;
import com.drogueria.pharmanet.exception.CustomFieldValidationException;
import com.drogueria.pharmanet.exception.UserNameOrIdNotExist;
import com.drogueria.pharmanet.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	private boolean checkUserNameAvailable(User user) throws CustomFieldValidationException {
		Optional<User> userFound = userRepository.findByUserName(user.getUserName());
		if(userFound.isPresent()) {
			throw new CustomFieldValidationException("Username no disponible", "userName");
		}
		return true;
	}
	
	private boolean checkPasswordValid(User user) throws CustomFieldValidationException {
		
		if(user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
			throw new CustomFieldValidationException("ConfirmPassword no debe estar vacio","confirmPassword");
		}
		
		if(!user.getPassword().equals(user.getConfirmPassword())){
			throw new CustomFieldValidationException("Password y ConfirmPassword no son iguales","password");
		}
		return true;
	}

	@Override
	public User createUser(User user) throws AuthenticationException, CustomFieldValidationException {
		if(checkUserNameAvailable(user) && checkPasswordValid(user)) {
			
			String encodePass = bCryptPasswordEncoder.encode(user.getPassword());
			user.setPassword(encodePass);
			user = userRepository.save(user);
		}
		return user;
	}

	@Override
	public User getUserById(Long id) throws UserNameOrIdNotExist{
		return userRepository.findById(id).orElseThrow(() -> new UserNameOrIdNotExist("El Id del usuario no existe"));
	}

	@Override
	public User updateUser(User fromUser) throws Exception {
		User toUser = getUserById(fromUser.getId());
		mapUser(fromUser, toUser);
		return userRepository.save(toUser);
	}
	
	protected void mapUser(User from, User to) {
		to.setUserName(from.getUserName());
		to.setFirstName(from.getFirstName());
		to.setLastName(from.getLastName());
		to.setEmail(from.getEmail());
		to.setRoles(from.getRoles());
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteUser(Long id) throws UserNameOrIdNotExist {
		User user = getUserById(id);
		userRepository.delete(user);
	}

	@Override
	public User changePassword(ChangePasswordForm form) throws Exception {
		User user = getUserById(form.getId());
		
		if(!isLoggedUserADMIN() && !user.getPassword().equals(form.getCurrentPassword())) {
			throw new Exception("Current password invalid");
		}
		
		if(user.getPassword().equals(form.getNewPassword())) {
			throw new Exception("Current password is equals to actual password");
		}
		
		if(!form.getNewPassword().equals(form.getConfirmPassword())) {
			throw new Exception("New password and Confirm password not equals");
		}
		
		String encodePass = bCryptPasswordEncoder.encode(form.getNewPassword());
		
		user.setPassword(encodePass);
		
		return userRepository.save(user);
		
	}
	
	private boolean isLoggedUserADMIN() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		UserDetails loggedUser = null;
		Object roles = null;
		
		if (principal instanceof UserDetails) {
			loggedUser = (UserDetails) principal;
		
			roles = loggedUser.getAuthorities().stream()
					.filter(x -> "ROLE_ADMIN".equals(x.getAuthority() ))      
					.findFirst().orElse(null);
		}
		return loggedUser != null ?true :false;
	}

}
