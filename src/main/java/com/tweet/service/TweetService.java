package com.tweet.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweet.exception.EntityNotFoundException;
import com.tweet.model.Tweet;
import com.tweet.model.User;
import com.tweet.repository.TweetRepository;
import com.tweet.repository.UserRepository;

@Service
public class TweetService {
	
	private TweetRepository tweetRepository;
	private UserRepository userRepository;

	public TweetService(TweetRepository tweetRepository) {
		super();
		this.tweetRepository = tweetRepository;
	}

	private String idGenrator() {
		  int min = 100;  
		  int max = 999;  
		        int b = (int)(Math.random()*(max-min+1)+min); 
		        System.out.println(b);
		return String.valueOf(b);
	}

	public Tweet addTweet(String username,Tweet tweet) {
		Date dt=new Date();
        String str= dt.toString();
		 str = str.replaceAll("IST", "");
		 System.out.println(str);
		 String id = idGenrator();
			tweet.setId(id);
			tweet.setLikes(0);
		 tweet.setPostedAt(str);
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

	public List<Tweet> getAllTweet(String fname) {
		
		String userid=fname;
		System.out.println(tweetRepository.findByUserName(userid));
		return tweetRepository.findByUserName(userid);
	}
	public List<Tweet> getRepliedTweet(String userid,String id ) {
		System.out.println(tweetRepository.findByParentId(id));
		return tweetRepository.findByParentId(id);
	}
	public void deleteTweet(String id) {
		tweetRepository.deleteById(id);
		
	}
	public Tweet replyTweet(String Username,String parentid,Tweet tweet) {
		Date dt=new Date();
        String str= dt.toString();
		 str = str.replaceAll("IST", "");
		 System.out.println(str);
		 String id = idGenrator();
			tweet.setId(id);
			tweet.setLikes(0);
		 tweet.setPostedAt(str);
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

	public List<Tweet> getTweets() {
		// TODO Auto-generated method stub
		
		return tweetRepository.findAll();
	}
}
