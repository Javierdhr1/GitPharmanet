package com.drogueria.pharmanet.service;

import javax.naming.AuthenticationException;
import javax.security.auth.login.AccountException;
import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;

import com.drogueria.pharmanet.dto.ChangePasswordForm;
import com.drogueria.pharmanet.entity.User;
import com.drogueria.pharmanet.exception.CustomFieldValidationException;
import com.drogueria.pharmanet.exception.UserNameOrIdNotExist;

public interface UserService {
	
	public Iterable<User> getAllUsers();

	public User createUser(User user) throws Exception;
	
	public User getUserById(Long id) throws Exception;
	
	public User updateUser(User user) throws Exception;
	
	public void deleteUser(Long id) throws UserNameOrIdNotExist;
	
	public User changePassword(ChangePasswordForm form) throws Exception;

}
