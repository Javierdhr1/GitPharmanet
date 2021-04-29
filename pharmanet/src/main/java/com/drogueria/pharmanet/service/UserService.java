package com.drogueria.pharmanet.service;

import javax.naming.AuthenticationException;
import javax.security.auth.login.AccountException;
import javax.validation.Valid;

import com.drogueria.pharmanet.entity.User;

public interface UserService {
	
	public Iterable<User> getAllUsers();

	public User createUser(User user) throws AccountException, AuthenticationException;

}
