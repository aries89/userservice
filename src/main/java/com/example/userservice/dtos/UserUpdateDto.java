package com.example.userservice.dtos;

import com.example.userservice.enums.UserRole;


public class UserUpdateDto {
	
	private String username;
	
	private String email;
	
	private String phoneNumber;
	
	private UserRole role;
	
	public UserUpdateDto() {
		
	}

	public UserUpdateDto(String username, String email, String phoneNumber, UserRole role) {
		super();
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
	
}
