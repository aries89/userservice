package com.example.userservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.userservice.dtos.UserRequestDto;
import com.example.userservice.dtos.UserResponseDto;
import com.example.userservice.dtos.UserUpdateDto;
import com.example.userservice.entities.User;



@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
	
	@Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
	User toEntity(UserRequestDto dto);
	
	UserResponseDto toDto(User user);
	
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "password", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
	void updateUserFromDto(UserUpdateDto dto, @MappingTarget User user);
}
