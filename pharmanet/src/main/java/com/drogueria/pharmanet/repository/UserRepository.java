package com.drogueria.pharmanet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.drogueria.pharmanet.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
