package com.drogueria.pharmanet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drogueria.pharmanet.entity.Product;
import com.drogueria.pharmanet.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}
	
}
