package com.example.userservice.services.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.userservice.dtos.UserRequestDto;
import com.example.userservice.dtos.UserResponseDto;
import com.example.userservice.dtos.UserUpdateDto;
import com.example.userservice.entities.User;
import com.example.userservice.exceptions.InvalidPasswordException;
import com.example.userservice.exceptions.UserNotFoundException;
import com.example.userservice.mappers.UserMapper;
import com.example.userservice.repos.UserRepository;
import com.example.userservice.services.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;

	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper,PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserResponseDto createUser(UserRequestDto userRequest) {
		User userEntity = userMapper.toEntity(userRequest);
		userEntity.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		User user = userRepository.save(userEntity);
		return userMapper.toDto(user);
	}

	@Override
	public UserResponseDto getUserById(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
		return userMapper.toDto(user);
	}

	@Override
	public List<UserResponseDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map(user -> userMapper.toDto(user)).toList();
	}

	@Override
	public UserResponseDto updateUser(Long userId, UserUpdateDto userUpdateDto) {
		User existingUser = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));

		userMapper.updateUserFromDto(userUpdateDto, existingUser);

		User updatedUser = userRepository.save(existingUser);
		return userMapper.toDto(updatedUser);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public void changePassword(Long userId, String oldPassword, String newPassword) {
		User existingUser = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
		if(passwordEncoder.matches(oldPassword, existingUser.getPassword())) {
			existingUser.setPassword(passwordEncoder.encode(newPassword));
			userRepository.save(existingUser);
		}else {
			throw new InvalidPasswordException("The given old password does not match with the one in the system.");
		}

	}

	@Override
	public UserResponseDto getUserByEmail(String email) {
		User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
		return userMapper.toDto(user);
	}

}
