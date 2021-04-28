package com.drogueria.pharmanet.service;

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

}
