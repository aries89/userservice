package com.example.userservice.services;

import java.util.List;

import com.example.userservice.dtos.UserRequestDto;
import com.example.userservice.dtos.UserResponseDto;
import com.example.userservice.dtos.UserUpdateDto;

public interface UserService {
	
	// Create / Register a new user
    UserResponseDto createUser(UserRequestDto userRequest);

    // Get user by ID
    UserResponseDto getUserById(Long userId);

    // Get all users (with optional pagination/filtering)
    List<UserResponseDto> getAllUsers();

    // Update user details
    UserResponseDto updateUser(Long userId, UserUpdateDto userUpdateDto);

    // Delete user
    void deleteUser(Long userId);

	/*
	 * // Authenticate user (login) AuthResponseDto authenticateUser(String email,
	 * String password);
	 */

    // Optional: Change user password
    void changePassword(Long userId, String oldPassword, String newPassword);

    // Optional: Find user by email (useful internally for auth)
    UserResponseDto getUserByEmail(String email);

}
