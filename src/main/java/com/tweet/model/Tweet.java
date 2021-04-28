package com.tweet.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tweets")
public class Tweet {
	
	private String id;
	private String parentId;
	private String userid;
	private String message;
	private String postedAt;
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
