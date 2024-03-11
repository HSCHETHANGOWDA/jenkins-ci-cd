package com.javatechie.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.javatechie.entity.User;
import com.javatechie.repositary.UserRepositary;
import com.javatechie.responseDto.ResponseDto;
import com.javatechie.service.UserService;
import com.javatechie.util.JenkinsUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepositary repositary;

	@Override
	public ResponseEntity<ResponseDto> getAllUser() {
		List<User> userList = repositary.findAll();
		if (!CollectionUtils.isEmpty(userList)) {
		return	ResponseEntity.ok().body(ResponseDto.builder().statusCode(HttpStatus.OK.value())
					.message("Data Fecthed Successfully").dataObject(userList).build());
		}
		return ResponseEntity.ok().body(ResponseDto.builder().statusCode(HttpStatus.OK.value())
				.message("Data Fecthed Successfully").dataObject(null).build());
	}

	@Override
	public ResponseEntity<ResponseDto> saveUser(User user) {
		User savedUser = repositary.save(user);
		if (JenkinsUtil.isObjectNotEmpty(savedUser) && JenkinsUtil.isIdValid(savedUser.getId())) {
			return ResponseEntity.accepted().body(ResponseDto.builder().statusCode(HttpStatus.OK.value())
					.message("Data Saved successfully ").build());
		}
		return ResponseEntity.ok().body(ResponseDto.builder().statusCode(HttpStatus.OK.value())
				.message("Data Failed Save in the Database ").build());
	}

	@Override
	public User getUserById(Long userID) {
		return repositary.findById(userID).get();
	}

}
