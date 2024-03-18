package com.javatechie.service;

import org.springframework.http.ResponseEntity;

import com.javatechie.entity.User;
import com.javatechie.responseDto.ResponseDto;
import com.javatechie.responseDto.UserDto;

public interface UserService {

	ResponseEntity<ResponseDto> getAllUser();

	ResponseEntity<ResponseDto> saveUser(User user);

	UserDto getUserById(Long userID);

}
