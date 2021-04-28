package com.tweet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tweet.model.Login;
import com.tweet.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
	@Query("{'email': ?0}")
	User findByEmail(String name);
	@Query("{'loginid': ?0}")
	User findByLoginId(String name);
	@Query("{'loginid': ?0, 'pwd':?1}")
	Login getUser(String loginid, String pwd);
}


