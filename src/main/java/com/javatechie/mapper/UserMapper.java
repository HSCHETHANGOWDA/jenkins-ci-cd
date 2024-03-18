package com.javatechie.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.javatechie.entity.User;
import com.javatechie.responseDto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

	
	UserDto userEntityTouserDto(User user);

	User userDtoTouserEntity(UserDto userDto);

}
