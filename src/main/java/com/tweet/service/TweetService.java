package com.tweet.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweet.exception.EntityNotFoundException;
import com.tweet.model.Tweet;
import com.tweet.repository.TweetRepository;
import com.tweet.repository.UserRepository;

@Service
public class TweetService {
	@Autowired
	private TweetRepository tweetRepository;
	@SuppressWarnings("unused")
	@Autowired
	private UserRepository userRepository;

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
		return tweetRepository.save(tweet);
		
	}

	public Tweet updateTweet(Tweet tweet, String id) throws EntityNotFoundException {
		List<Tweet> requestedTweet=tweetRepository.findById(id);
		Tweet updatedTweet =requestedTweet.get(1);
		updatedTweet.setMessage(tweet.getMessage());
		return tweetRepository.save(updatedTweet);
		}

	public List<Tweet> getAllTweet(String fname) {
		
		String userid=fname;
		System.out.println(tweetRepository.findByUserid(userid));
		return tweetRepository.findByUserid(userid);
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
		return tweetRepository.save(tweet);
		
	}
	public Tweet likeTweet(String id) throws EntityNotFoundException {
		List<Tweet> requestedTweet=tweetRepository.findById(id);
		Tweet updatedTweet =requestedTweet.get(1);
		int currentLikes=updatedTweet.getLikes();
		updatedTweet.setLikes(++currentLikes);
		return tweetRepository.save(updatedTweet);
	}

	public List<Tweet> getTweets() {
		// TODO Auto-generated method stub
		
		return tweetRepository.findAll();
	}
}
