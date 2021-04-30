package com.drogueria.pharmanet.exception;

public class UserNameOrIdNotExist extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6499654375482148676L;
	
	public UserNameOrIdNotExist() {
		super("Usuario o Id no Encontrado");
	}
	
	public UserNameOrIdNotExist(String message) {
		super(message);
	}

}
