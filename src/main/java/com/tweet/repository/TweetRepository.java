package com.tweet.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.tweet.model.Tweet;

@Repository
public class TweetRepository {

	@Autowired
	private DynamoDBMapper dynamoDBMapper;

	public Tweet save(Tweet tweet) {
		dynamoDBMapper.batchSave(tweet);
		return tweet;
	}
	
	public List<Tweet> findById(String id) {
		HashMap<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		eav.put(id, new AttributeValue().withS(id));
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
				.withFilterExpression("begins_with(id,:v1)").withExpressionAttributeValues(eav);
		List<Tweet> result = dynamoDBMapper.scan(Tweet.class, scanExpression);

		return result;
	}
	
	public List<Tweet> findByUserid(String userid) {
		HashMap<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		eav.put(userid, new AttributeValue().withS(userid));
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
				.withFilterExpression("begins_with(userid,:v1)").withExpressionAttributeValues(eav);
		List<Tweet> result = dynamoDBMapper.scan(Tweet.class, scanExpression);

		return result;
	}

	public List<Tweet> findByParentId(String parentId) {
		HashMap<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		eav.put(parentId, new AttributeValue().withS(parentId));
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
				.withFilterExpression("begins_with(parentId,:v1)").withExpressionAttributeValues(eav);
		List<Tweet> result = dynamoDBMapper.scan(Tweet.class, scanExpression);

		return result;
	}
	
	public void deleteById(String id) {
		Tweet tweet = dynamoDBMapper.load(Tweet.class, id);
		dynamoDBMapper.delete(tweet);
	}
	
	public List<Tweet> findAll() {
		DynamoDBScanExpression scanner = new DynamoDBScanExpression();
		List<Tweet> result = dynamoDBMapper.scan(Tweet.class, scanner);
		return result;
	}
	
}
