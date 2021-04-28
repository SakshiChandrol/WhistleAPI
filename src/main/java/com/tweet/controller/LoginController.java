package com.tweet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweet.model.Login;
import com.tweet.service.UserService;


@RestController
@RequestMapping("/api/v1.0/tweets")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<?> onValidate(@RequestBody Login login) throws Exception {
		try {
			userService.getUser(login);
		} catch (Exception e) {
			throw new Exception("data not present");
		}
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}
	
	@PostMapping("{username}/forget")
	public ResponseEntity<?> onForget(@PathVariable("username") String loginid,@RequestBody String pwd ) throws Exception {
		try {
			userService.setPassword(loginid,pwd);
		} catch (Exception e) {
			throw new Exception("data not present");
		}
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}

}
