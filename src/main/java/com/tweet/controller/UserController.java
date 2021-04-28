package com.tweet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweet.model.User;
import com.tweet.service.UserService;

@RestController
@RequestMapping("/api/v1.0/tweets/users/all")
public class UserController {

	@Autowired
	UserService userSerivce;
	
	@GetMapping
	public ResponseEntity<List<String>> getAllUser() {
		return ResponseEntity.ok(userSerivce.getUsers());
		
	}
}
