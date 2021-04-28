package com.drogueria.pharmanet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.drogueria.pharmanet.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

}
