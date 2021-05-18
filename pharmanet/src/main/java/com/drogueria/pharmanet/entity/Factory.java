package com.drogueria.pharmanet.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Factory implements Serializable{

	private static final long serialVersionUID = 6533906957633687942L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nameFactory;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameFactory() {
		return nameFactory;
	}

	public void setNameFactory(String nameFactory) {
		this.nameFactory = nameFactory;
	}
	
	
	
}
