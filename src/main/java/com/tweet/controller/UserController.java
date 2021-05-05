package com.tweet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweet.model.User;
import com.tweet.service.UserService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1.0/tweets")
public class UserController {

	@Autowired
	UserService userSerivce;
	
	@GetMapping("/users/all")
	public ResponseEntity<List<User>> getAllUser() {
		return ResponseEntity.ok(userSerivce.getUsers());
	}
	
		@GetMapping("/user/search/{fname}")
		public ResponseEntity<User> getUserWithName(@PathVariable String fname){
			return ResponseEntity.ok(userSerivce.getFname(fname));
		
		
	}
}
