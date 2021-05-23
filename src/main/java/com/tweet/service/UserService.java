package com.tweet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweet.exception.EntityNotFoundException;
import com.tweet.model.Login;
import com.tweet.model.User;
import com.tweet.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User registerUser(User user) throws Exception {
		boolean isExisting = false;
		String email=user.getEmail();
		String loginId=user.getLoginid();
		String id = idGenrator();
		user.setId(id);
		if(email != null && !"".equals(email)&&loginId != null && !"".equals(loginId)) {
			isExisting = checkExistingUser(email,loginId);
		}
		if(!isExisting) {
			throw new EntityNotFoundException(String.format("User already present"));
		}
		return userRepository.save(user);
		
	}
	
	private String idGenrator() {
		  int min = 100;  
		  int max = 999;  
		        int b = (int)(Math.random()*(max-min+1)+min); 
		        System.out.println(b);
		return String.valueOf(b);
	}
	
	

	public User getUser(Login login) throws Exception {
		User userWithLoginId;
		boolean isLoggedIn=false;
		String loginid = login.getLoginid();
		String pwd = login.getPwd();
		//if(loginid != null &&  !"".equals(loginid) && pwd != null &&  !"".equals(pwd)) {
			//Login loginWithCred = userRepository.getUser(loginid);
		//System.out.println(loginWithCred);
			//if(!(loginid.equals(loginWithCred.getLoginid())) && !(pwd.equals(loginWithCred.getPwd())))
			//{
			////	throw new Exception("data not present");
		//	}
		//	else {
				userWithLoginId=userRepository.findByEmail(loginid);
		//	    isLoggedIn = true;
	//		    userWithLoginId.setLogged(isLoggedIn);
			//}
	//	}
		//else {
		///	throw new Exception("null");
		//}
		return userWithLoginId;
		
	}
	
	public void setPassword(String loginid, String pwd) throws Exception {
		User userWithLoginId=userRepository.findByLoginId(loginid);
		if(userWithLoginId != null) {
			 userWithLoginId.setPwd(pwd);
			 userRepository.save(userWithLoginId); }
		else
			throw new Exception("data not present");
		
	}
	private boolean checkExistingUser(String email, String loginId) {
		User userWithEmail=userRepository.findByEmail(email);
		User userWithLoginId=userRepository.findByLoginId(loginId);
		if(userWithEmail != null || userWithLoginId != null)
			return false;
		else
			return true;	
	}

	public List<User> getUsers() {
		 List<User> users = userRepository.findAll();
		 return users;
	}

	public User getFname(String fname) {
		System.out.println(userRepository.findByLoginId(fname));
		return userRepository.findByLoginId(fname);
	}


}
