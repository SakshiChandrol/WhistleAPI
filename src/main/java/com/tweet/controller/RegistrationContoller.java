package com.tweet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweet.exception.EntityNotFoundException;
import com.tweet.model.User;
import com.tweet.service.UserService;


@RestController
@RequestMapping("/api/v1.0/tweets/register")
public class RegistrationContoller {

	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<?> registerUser(@RequestBody User user) throws EntityNotFoundException {
			try {
				userService.registerUser(user);
			} catch (Exception e) {
				System.out.println("fgh");
				throw new EntityNotFoundException(String.format("User already present"));
			}
		return ResponseEntity.status(HttpStatus.CREATED).build();
		}
}
