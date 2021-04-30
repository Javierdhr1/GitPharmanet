package com.drogueria.pharmanet.exception;

public class CustomFieldValidationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6048570365396452782L;

	private String fieldName;
	
	public CustomFieldValidationException(String message, String fieldName) {
		super(message);
		this.fieldName = fieldName;
	}
	
	public String getFieldName() {
		return this.fieldName;
	}
}
