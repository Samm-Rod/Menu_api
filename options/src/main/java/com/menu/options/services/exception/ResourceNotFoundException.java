package com.menu.options.services.exception;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object msg) {
		super("Resource not found. Id");
	}
	
}
