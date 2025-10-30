package com.example.userservice.dtos;


import com.example.userservice.enums.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class UserRequestDto {
	
	@NotNull
	@NotBlank
	private String username;
	
	@NotNull
	@NotBlank
	@Email
	private String email;
	
	@NotNull
	@NotBlank
	private String phoneNumber;
	
	@NotNull
	@NotBlank
	private String password;
	
	@NotNull
	private UserRole role;
	
	

	public UserRequestDto() {
		
	}

	public UserRequestDto(@NotNull @NotBlank String username, @NotNull @NotBlank @Email String email,
			@NotNull @NotBlank String phoneNumber, @NotNull @NotBlank String password, @NotNull UserRole role) {
		super();
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
	

}
