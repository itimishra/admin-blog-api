package com.spring.adminblogapi.service;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.spring.adminblogapi.controller.AdminBlogApiUriConstants;
import com.spring.adminblogapi.pojo.Address;
import com.spring.adminblogapi.pojo.Company;
import com.spring.adminblogapi.pojo.Post;
import com.spring.adminblogapi.pojo.User;

@RunWith(MockitoJUnitRunner.class)
public class UserPostDetailsServiceTest {

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private UserPostDetailsService underTest;

	@Test
	public void testGetUserList() {
		//given
		User user1 = new User(new Long(1), "someName1", "someUserName", "someEmail", new Address(), "somePhone", "someWebsite", new Company());
		User user2 = new User(new Long(2), "someName2", "someUserName", "someEmail", new Address(), "somePhone", "someWebsite", new Company());
		User user3 = new User(new Long(3), "someName3", "someUserName", "someEmail", new Address(), "somePhone", "someWebsite", new Company());
		User user4 = new User(new Long(4), "someName4", "someUserName", "someEmail", new Address(), "somePhone", "someWebsite", new Company());
		User[] users = {user1, user2, user3, user4};

		List<User> actual = Arrays.asList(users);

		//when
		when(restTemplate.getForObject(AdminBlogApiUriConstants.GET_ALL_USERS , User[].class)).thenReturn(users);

		List<User> expected = underTest.getUserList();
		//then
		Assert.assertEquals(actual, expected);

	}	
	@Test
	public void testGetPostList() {
		//given
		Post post1 = new Post(new Long(1), new Long(1), "post1", "body1");
		Post post2 = new Post(new Long(1), new Long(2), "post2", "body1");
		Post post3 = new Post(new Long(3), new Long(3), "post3", "body1");
		Post post4 = new Post(new Long(4), new Long(4), "post4", "body1");
		Post[] posts = {post1, post2, post3, post4};

		List<Post> actual = Arrays.asList(posts);

		//when
		when(restTemplate.getForObject(AdminBlogApiUriConstants.GET_ALL_POSTS , Post[].class)).thenReturn(posts);

		List<Post> expected = underTest.getPostList();
		//then
		Assert.assertEquals(actual, expected);
	}
}
