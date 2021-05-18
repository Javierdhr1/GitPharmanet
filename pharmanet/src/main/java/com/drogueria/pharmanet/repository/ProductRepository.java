package com.drogueria.pharmanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.drogueria.pharmanet.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
