package com.javatechie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.entity.User;
import com.javatechie.responseDto.ResponseDto;
import com.javatechie.responseDto.UserDto;
import com.javatechie.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService service;
	
	@GetMapping(value = "/getAllUser")
	public ResponseEntity<ResponseDto> getAllUser(){
		return service.getAllUser();
	}
	
	@PostMapping(value = "/saveUser")
	public ResponseEntity<ResponseDto> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@GetMapping(value = "/getUserById")
	public UserDto getUserById(@RequestParam Integer userID) {
		return service.getUserById(Long.valueOf(userID));
	}

}
