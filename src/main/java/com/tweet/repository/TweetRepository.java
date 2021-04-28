package com.tweet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tweet.model.Tweet;

@Repository
public interface TweetRepository extends MongoRepository<Tweet, String> {
	 @Query("{'userid': ?0}")
		List<Tweet> findByUserName(String userid);
	 @Query("{'parentId': ?0 }")
	    List<Tweet> findByParentId(String parentId);
}
