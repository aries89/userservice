package com.example.userservice.exceptions;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -704910168632180162L;

	public UserNotFoundException(String email) {
		super("User not found with id: " + email);
	}

	public UserNotFoundException(Long userId) {
		super("User not found with id: " + userId);
	}

}
