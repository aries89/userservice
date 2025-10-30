package com.example.userservice.dtos;

import java.time.LocalDateTime;

import com.example.userservice.enums.UserRole;


public class UserResponseDto {
	
	private String username;
	
	private String email;
	
	private String phoneNumber;
	
	private UserRole role;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
	
	public UserResponseDto() {
		
	}

	public UserResponseDto(String username, String email, String phoneNumber, UserRole role, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
