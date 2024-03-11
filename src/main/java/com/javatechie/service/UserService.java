package com.javatechie.service;

import org.springframework.http.ResponseEntity;

import com.javatechie.entity.User;
import com.javatechie.responseDto.ResponseDto;

public interface UserService {

	ResponseEntity<ResponseDto> getAllUser();

	ResponseEntity<ResponseDto> saveUser(User user);

	User getUserById(Long userID);

}
