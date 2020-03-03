package com.spring.adminblogapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.adminblogapi.controller.AdminBlogApiUriConstants;
import com.spring.adminblogapi.pojo.Post;
import com.spring.adminblogapi.pojo.User;
import com.spring.adminblogapi.pojo.UserPostsDetails;

@Service
public class UserPostDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(UserPostDetailsService.class);

	@Autowired
	private RestTemplate restTemplate;

	public List<UserPostsDetails> retrieveUserPostDetailsList(){
		logger.info("Fetching User and Post Details");
		List<User> users = getUserList();
		List<Post> posts = getPostList();
		List<UserPostsDetails> userPostsDetails = new ArrayList<UserPostsDetails>();	

		users.stream().forEach(user -> userPostsDetails.add(new UserPostsDetails(user, posts.stream().filter(post -> 
		post.getUserId().equals(user.getId())).collect(Collectors.toList()))));

		return userPostsDetails;
	}

	public List<User> getUserList() {
		logger.info("Fetching All Users");
		User[] allUsers = restTemplate.getForObject(AdminBlogApiUriConstants.GET_ALL_USERS , User[].class);
		List<User> userList = Stream.of(allUsers).collect(Collectors.toList());
		return userList;
	}	

	public List<Post> getPostList() {
		logger.info("Fetching All Posts");
		Post[] allPosts = restTemplate.getForObject(AdminBlogApiUriConstants.GET_ALL_POSTS , Post[].class);
		List<Post> postList = Stream.of(allPosts).collect(Collectors.toList());
		return postList;
	}
}
