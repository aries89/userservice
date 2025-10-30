package com.example.userservice.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.dtos.ChangePasswordRequestDto;
import com.example.userservice.dtos.UserRequestDto;
import com.example.userservice.dtos.UserResponseDto;
import com.example.userservice.dtos.UserUpdateDto;
import com.example.userservice.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto userRequest) {
		UserResponseDto createdUser = userService.createUser(userRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);

	}

	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {
		UserResponseDto user = userService.getUserById(id);
		return ResponseEntity.ok(user);

	}

	@GetMapping
	public ResponseEntity<List<UserResponseDto>> getAllUsers() {
		List<UserResponseDto> users = userService.getAllUsers();
		return ResponseEntity.ok(users);

	}

	@PutMapping("/{id}")
	public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @RequestBody UserUpdateDto userUpdateDto) {
		UserResponseDto updatedUser = userService.updateUser(id, userUpdateDto);
		return ResponseEntity.status(HttpStatus.OK).body(updatedUser);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();

	}

	// -----------------------------
	// Authenticate User (Login)
	// POST /users/login
	// -----------------------------
	/*
	 * @PostMapping("/login") public ResponseEntity<AuthResponseDto>
	 * login(@RequestBody LoginRequestDto loginRequest) { // call
	 * userService.authenticateUser(...) }
	 */

	
	@PutMapping("/{id}/password")
	public ResponseEntity<Void> changePassword(@PathVariable Long id,
			@Valid @RequestBody ChangePasswordRequestDto request) { 
		userService.changePassword(id, request.getOldPassword(), request.getNewPassword());
		return ResponseEntity.noContent().build();
	}

}
