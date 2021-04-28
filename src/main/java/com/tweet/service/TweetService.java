package com.tweet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweet.exception.EntityNotFoundException;
import com.tweet.model.Tweet;
import com.tweet.repository.TweetRepository;

@Service
public class TweetService {
	
	private TweetRepository tweetRepository;

	public TweetService(TweetRepository tweetRepository) {
		super();
		this.tweetRepository = tweetRepository;
	}

	public Tweet addTweet(String username,Tweet tweet) {
		tweet.setUserid(username);
		return tweetRepository.insert(tweet);
		
	}

	public Tweet updateTweet(Tweet tweet, String id) throws EntityNotFoundException {
		Optional<Tweet> requestedTweet=tweetRepository.findById(id);
		if(!requestedTweet.isPresent()) {
			throw new EntityNotFoundException(String.format("No tweet found"));
		}
		Tweet updatedTweet =requestedTweet.get();
		updatedTweet.setMessage(tweet.getMessage());
		return tweetRepository.save(updatedTweet);
		}

	public List<Tweet> getAllTweet(String userid) {
		return tweetRepository.findByUserName(userid);
	}
	public List<Tweet> getRepliedTweet(String userid,String id ) {
		return tweetRepository.findByParentId(id);
	}
	public void deleteTweet(String id) {
		tweetRepository.deleteById(id);
		
	}
	public Tweet replyTweet(String Username,String parentid,Tweet tweet) {
		tweet.setUserid(Username);
		tweet.setParentId(parentid);
		return tweetRepository.insert(tweet);
		
	}
	public Tweet likeTweet(String id) throws EntityNotFoundException {
		Optional<Tweet> requestedTweet=tweetRepository.findById(id);
		if(!requestedTweet.isPresent()) {
			throw new EntityNotFoundException(String.format("No tweet found"));
		}
		Tweet updatedTweet =requestedTweet.get();
		int currentLikes=updatedTweet.getLikes();
		updatedTweet.setLikes(++currentLikes);
		return tweetRepository.save(updatedTweet);
	}
}
