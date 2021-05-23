package com.tweet.controller;



//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweet.WhistleApiApplication;
import com.tweet.model.Login;
import com.tweet.model.User;
import com.tweet.repository.UserRepository;
import com.tweet.service.UserService;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1.0/tweets")
public class LoginController {
	
	//private static final Logger LOG = Logger.getLogger(LoginController.class.getName());
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/login")
	public void onValidate(@RequestBody Login login) throws Exception {
		 User response = userService.getUser(login);
		 // LOG.log(Level.INFO, "/elkdemo - &gt; " + response);
		userRepository.findByEmail(login.getLoginid());
		
	}
	
	@PutMapping("{username}/forget")
	public ResponseEntity<?> onForget(@PathVariable("username") String loginid,@RequestBody String pwd ) throws Exception {
		try {
			userService.setPassword(loginid,pwd);
		} catch (Exception e) {
			throw new Exception("data not present");
		}
		//LOG.log(Level.INFO, "/elkdemo - &gt; " + "onForget");
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}

}
