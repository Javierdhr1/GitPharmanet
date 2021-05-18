package com.drogueria.pharmanet.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.drogueria.pharmanet.repository.ProductRepository;

public class PassGenerator {

	@Autowired
	private static ProductRepository productRepository;
	
	public static void main(String[] args) {
		
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
//		
//		System.out.println(bCryptPasswordEncoder.encode("123"));
		
		
		
		
		productRepository.save(null);
		
	}
}
