package com.tweet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweet.exception.EntityNotFoundException;
import com.tweet.model.Tweet;
import com.tweet.service.TweetService;

@RestController
@RequestMapping("/api/v1.0/tweets")
public class TweetsController {
	
	
	@Autowired
	TweetService tweetService;

	@PostMapping("/{username}/add")
	public ResponseEntity<Tweet> addTweet(@PathVariable String username ,@RequestBody Tweet tweet) {
		tweetService.addTweet(username ,tweet);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		}
	@PutMapping("/{username}/update/{id}")	
	public ResponseEntity<Tweet> updateTweet(@RequestBody Tweet tweet,@PathVariable String id ) throws EntityNotFoundException {
			return ResponseEntity.ok(tweetService.updateTweet(tweet,id));
		}
	@GetMapping("/{username}")
	public ResponseEntity<List<Tweet>> getAllTweet(@PathVariable String username) {
		return ResponseEntity.ok(tweetService.getAllTweet(username));
		
	}
	@GetMapping("/{username}/replyed/{id}")
	public ResponseEntity<List<Tweet>> getRepliedTweet(@PathVariable String username, @PathVariable String id) {
		return ResponseEntity.ok(tweetService.getRepliedTweet(username, id));
		
	}
	@DeleteMapping("/{username}/delete/{id}")
	public ResponseEntity deleteTweet(@PathVariable String id) {
		tweetService.deleteTweet(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	@PostMapping("/{username}/reply/{id}")
	public ResponseEntity<Tweet> replyTweet(@PathVariable String username,@PathVariable String id,@RequestBody Tweet tweet) {
		tweetService.replyTweet(username,id,tweet);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		}
	@PutMapping("/{username}/like/{id}")	
	public ResponseEntity<Tweet> likeTweet(@PathVariable String id ) throws EntityNotFoundException {
			return ResponseEntity.ok(tweetService.likeTweet(id));
		}
}
