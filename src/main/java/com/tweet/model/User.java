package com.tweet.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "User")
public class User {
	@DynamoDBHashKey
	private String id;
	@DynamoDBAttribute
	private String fname;
	@DynamoDBAttribute
	private String lname;
	@DynamoDBAttribute
	private String email;
	@DynamoDBAttribute
	private String loginid;
	@DynamoDBAttribute
	private String pwd;
	@DynamoDBAttribute
	private String phone;
	@DynamoDBAttribute
	private boolean isLogged;
	
	
	public User() {
		
		// TODO Auto-generated constructor stub
	}
	public User(String id, String fname, String lname, String email, String loginid, String pwd,
			String phone) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.loginid = loginid;
		this.pwd = pwd;
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isLogged() {
		return isLogged;
	}
	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
	
}
