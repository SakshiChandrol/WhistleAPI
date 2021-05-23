package com.tweet.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Tweet")
public class Tweet {
	
	@DynamoDBHashKey
	private String id;
	@DynamoDBAttribute
	private String parentId;
	@DynamoDBAttribute
	private String userid;
	@DynamoDBAttribute
	private String message;
	@DynamoDBAttribute
	private String postedAt;
	@DynamoDBAttribute
	private int likes;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPostedAt() {
		return postedAt;
	}
	public void setPostedAt(String postedAt) {
		this.postedAt = postedAt;
	}
	public Tweet(String id, String parentId, String userid, String message, String postedAt, int likes) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.userid = userid;
		this.message = message;
		this.postedAt = postedAt;
		this.likes = likes;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	
}
