package com.example.userservice.exceptions;

public class InvalidPasswordException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6354547691911513525L;

	public InvalidPasswordException (String message) {
		super(message);
	}

}
