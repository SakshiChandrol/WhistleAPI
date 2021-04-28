package com.tweet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tweet.exception.EntityNotFoundException;
import com.tweet.model.Login;
import com.tweet.model.User;
import com.tweet.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public User registerUser(User user) throws Exception {
		boolean isExisting = false;
		String email=user.getEmail();
		String loginId=user.getLoginid();
		if(email != null && !"".equals(email)&&loginId != null && !"".equals(loginId)) {
			isExisting = checkExistingUser(email,loginId);
		}
		if(!isExisting) {
			throw new EntityNotFoundException(String.format("User already present"));
		}
		return userRepository.insert(user);
		
	}
	
	public void getUser(Login login) throws Exception {
		String loginid = login.getLoginid();
		String pwd = login.getPwd();
		if(loginid != null &&  !"".equals(loginid) && pwd != null &&  !"".equals(pwd)) {
			Login loginWithCred = userRepository.getUser(loginid,pwd);
			if(!(loginid.equals(loginWithCred.getLoginid())) && !(pwd.equals(loginWithCred.getPwd())))
			{
				throw new Exception("data not present");
			}
		}
		
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

	public List<String> getUsers() {
		List<String> allUser =  new ArrayList<String>();
		 List<User> users = userRepository.findAll();
		 for(User user : users) {
			 String firstName=user.getFname();
			 String lastName =user.getLname();
			 allUser.add(firstName+" "+lastName);
		 }
		 return allUser;
	}


}
