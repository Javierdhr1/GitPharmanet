package com.drogueria.pharmanet.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.drogueria.pharmanet.entity.Role;
import com.drogueria.pharmanet.entity.User;
import com.drogueria.pharmanet.repository.UserRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User appUser = userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("Login Username Invalido"));
		
		Set grantList = new HashSet();
		
		for(Role role : appUser.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getDescription());
			grantList.add(grantedAuthority);
		}
		
		UserDetails user = new org.springframework.security.core.userdetails.User(username,appUser.getPassword(),grantList);
		
		return user;
	}

}
