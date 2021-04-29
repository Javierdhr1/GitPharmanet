package com.drogueria.pharmanet.service;

import java.util.Optional;

import javax.naming.AuthenticationException;
import javax.security.auth.login.AccountException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drogueria.pharmanet.entity.User;
import com.drogueria.pharmanet.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	private boolean checkUserNameAvailable(User user) throws AccountException {
		Optional<User> userFound = userRepository.findByUserName(user.getUserName());
		if(userFound.isPresent()) {
			throw new AccountException("Username no disponible");
		}
		return true;
	}
	
	private boolean checkPasswordValid(User user) throws AuthenticationException {
		if(!user.getPassword().equals(user.getConfirmPassword())){
			throw new AuthenticationException("Password y ConfirmPassword no son iguales");
		}
		return true;
	}

	@Override
	public User createUser(User user) throws AccountException, AuthenticationException {
		if(checkUserNameAvailable(user) && checkPasswordValid(user)) {
			user = userRepository.save(user);
		}
		return user;
	}

}
