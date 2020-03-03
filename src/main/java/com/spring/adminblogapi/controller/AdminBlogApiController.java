package com.spring.adminblogapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.adminblogapi.pojo.UserPostsDetails;
import com.spring.adminblogapi.service.UserPostDetailsService;

/**
 * Handles the Admin Blog API
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminBlogApiController {

	private static final Logger logger = LoggerFactory.getLogger(AdminBlogApiController.class);

	@Autowired
	private UserPostDetailsService userDetailsService;

	@GetMapping(path="/blog")
	public List<UserPostsDetails> getUserPostsDetails() {
		logger.info("Fetching Post related to a users ");
		List<UserPostsDetails> userPostsDetails = userDetailsService.retrieveUserPostDetailsList();	

		return userPostsDetails;
	}

}
