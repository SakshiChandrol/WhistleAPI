package com.tweet;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class WhistleApiApplicationTests {
	/*@MockBean
	private UserService service;
	
	@MockBean
	private UserRepository repository;
	
	@MockBean
	private TweetRepository repo;
	
	@Test
	public void  getUsersTest() {
       when(repository.findAll()).thenReturn(Stream.of(new User("104","mini", "chandrol","mini1234@gmail.com", "mini12345", "7389493428","test1234"))
		.collect(Collectors.toList()));
      List<User> expected = new ArrayList<User>();
      User user = new User("104","mini", "chandrol","mini1234@gmail.com", "mini12345", "7389493428","test1234");
      expected.add(user);
		List<User> actual = repository.findAll();
		assertEquals(expected, actual);
	}

	@Test
	public void getTestFname() {
		String fname ="mini12345";
		when(repository.findByLoginId(fname)).thenReturn((new User("104","mini", "chandrol","mini1234@gmail.com", "mini12345", "7389493428","test1234")));	
		User actual = repository.findByLoginId(fname);
		User expected	 = new User("104","mini", "chandrol","mini1234@gmail.com", "mini12345", "7389493428","test1234");
		assertEquals(expected, actual);	
	}
	
	@Test
	public void getTestUser() {
		String loginid ="mini12345";
		when(repository.findByLoginId(loginid)).thenReturn((new User("104","mini", "chandrol","mini1234@gmail.com", "mini12345", "7389493428","test1234")));	
		User actual = repository.findByLoginId(loginid);
		User expected	 = new User("104","mini", "chandrol","mini1234@gmail.com", "mini12345", "7389493428","test1234");
		assertEquals(expected, actual);
	}
	
	@Test
	public void getTestAllTweet() {
		String userid ="SakshiChandrol";
		when(repo.findByUserName(userid)).thenReturn(Stream.of(new Tweet( "1234568","1234567","SakshiChandrol","hi Anshul",  " 4h ago",0))
				.collect(Collectors.toList()));	
		List <Tweet> actual = repo.findByUserName(userid);
		List <Tweet> expected	 = new ArrayList<Tweet>();
		Tweet t =new Tweet( "1234568","1234567","SakshiChandrol","hi Anshul",  " 4h ago",0);
		expected.add(t);
		assertEquals(expected, actual);	
	}
	
	@Test
	public void getTestRepliedTweet() {
		String id ="1234567";
		when(repo.findByUserName(id)).thenReturn(Stream.of(new Tweet( "1234568","1234567","SakshiChandrol","hi Anshul",  " 4h ago",0))
				.collect(Collectors.toList()));	
		List <Tweet> actual = repo.findByUserName(id);
		List <Tweet> expected	 = new ArrayList<Tweet>();
		Tweet t =new Tweet( "1234568","1234567","SakshiChandrol","hi Anshul", " 4h ago",0);
		expected.add(t);
		assertEquals(expected, actual);
	}
	
	@Test
	public void getTestTweets() {
		when(repo.findAll()).thenReturn(Stream.of(new Tweet( "1234568","1234567","SakshiChandrol","hi Anshul",  " 4h ago",0))
				.collect(Collectors.toList()));	
		List <Tweet> actual = repo.findAll();
		List <Tweet> expected	 = new ArrayList<Tweet>();
		Tweet t =new Tweet( "1234568","1234567","SakshiChandrol","hi Anshul", " 4h ago",0);
		expected.add(t);
		assertEquals(expected, actual);
	}
	
	@Test
	public void registerUserTest() {
		User user	 = new User("104","mini", "chandrol","mini1234@gmail.com", "mini12345", "7389493428","test1234");
		when(repository.insert(user)).thenReturn(new User("104","mini", "chandrol","mini1234@gmail.com", "mini12345", "7389493428","test1234"));	
		User actual = repository.insert(user);
		User expected	 = new User("104","mini", "chandrol","mini1234@gmail.com", "mini12345", "7389493428","test1234");
		
		assertEquals(expected, actual);
	}
	
	 
	 @Test
	 public void setPasswordTest() { 
	 User userWithLoginId	 = new User("104","mini", "chandrol","mini1234@gmail.com", "mini12345", "7389493428","test1234");
		when(repository.save(userWithLoginId)).thenReturn(new User("104","mini", "chandrol","mini1234@gmail.com", "mini12345", "7389493428","test1234"));	
		User actual = repository.save(userWithLoginId);
		User expected	 = new User("104","mini", "chandrol","mini1234@gmail.com", "mini12345", "7389493428","test1234");
		assertEquals(expected, actual);
	 }
	 
	 @Test
	 public void addTweetTest() {
		 Tweet tweet = new Tweet( "1234568","1234567","SakshiChandrol","hi Anshul",  " 4h ago",0);
	 when(repo.insert(tweet)).thenReturn(new Tweet( "1234568","1234567","SakshiChandrol","hi Anshul",  " 4h ago",0));	
		Tweet actual = repo.insert(tweet);
		Tweet expected =new Tweet( "1234568","1234567","SakshiChandrol","hi Anshul", " 4h ago",0);
		assertEquals(expected, actual);
	 }
	 
	 @Test
	 public void updateTweetTest() {
		 Tweet updatedTweet = new Tweet( "1234568","1234567","SakshiChandrol","hi Anshul !!!!!",  " 4h ago",0);
		 when(repo.save(updatedTweet)).thenReturn(new Tweet( "1234568","1234567","SakshiChandrol","hi Anshul !!!!!",  " 4h ago",0));	
			Tweet actual = repo.save(updatedTweet);
			Tweet expected =new Tweet( "1234568","1234567","SakshiChandrol","hi Anshul !!!!!", " 4h ago",0);
			assertEquals(expected, actual);
	 }
	 */
	
}
