package com.tweet.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.tweet.model.Login;
import com.tweet.model.Tweet;
import com.tweet.model.User;

@Repository
public class UserRepository {


	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	public User save(User user) {
		dynamoDBMapper.batchSave(user);
		return user;
	}

	public User findByEmail(String email) {
		User result = dynamoDBMapper.load(User.class, email);
		return result;
	}

	public User findByLoginId(String loginid) {
		User result = dynamoDBMapper.load(User.class, loginid);
	return result;
	}

	public List<User> findAll() {
		DynamoDBScanExpression scanner = new DynamoDBScanExpression();
		List<User> result = dynamoDBMapper.scan(User.class, scanner);
		return result;
	}

	//public Login getUser(String loginid) {
	//	Login result = dynamoDBMapper.load(User.class, loginid);
	//	return result;
	//}
}
