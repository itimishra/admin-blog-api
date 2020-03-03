package com.spring.adminblogapi.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.spring.adminblogapi.pojo.Address;
import com.spring.adminblogapi.pojo.Company;
import com.spring.adminblogapi.pojo.Post;
import com.spring.adminblogapi.pojo.User;
import com.spring.adminblogapi.pojo.UserPostsDetails;
import com.spring.adminblogapi.service.UserPostDetailsService;

/**
 * Controller Test
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AdminBlogApiControllerTest {

	@Mock
	private UserPostDetailsService userDetailsService;

	@InjectMocks
	private AdminBlogApiController underTest;

	@Test
	public void testGetUserPostsDetails() throws Exception {
		//given
		User user1 = new User(new Long(1), "someName1", "someUserName", "someEmail", new Address(), "somePhone", "someWebsite", new Company());

		Post post1 = new Post(new Long(1), new Long(1), "post1", "body1");
		Post post2 = new Post(new Long(1), new Long(2), "post2", "body1");
		Post post3 = new Post(new Long(2), new Long(3), "post3", "body1");
		Post post4 = new Post(new Long(2), new Long(4), "post4", "body1");
		Post[] posts = {post1, post2, post3, post4};

		List<Post> userPosts = Arrays.asList(posts);

		UserPostsDetails userDetails1 = new UserPostsDetails(user1, userPosts);

		List<UserPostsDetails> actual = new ArrayList<UserPostsDetails>();
		actual.add(userDetails1);

		//when
		when(userDetailsService.retrieveUserPostDetailsList()).thenReturn(actual);

		List<UserPostsDetails> expected = underTest.getUserPostsDetails();	
		//then
		Assert.assertEquals(actual, expected);

	}

}
