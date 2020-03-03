package com.spring.adminblogapi.pojo;

import java.util.List;

public class UserPostsDetails {

	private User userDetails;
	private List<Post> userPost;
	
	/**
	 * Default Constructor
	 */
	public UserPostsDetails() {
	}

	/**
	 * @param userDetails
	 * @param List of userPost
	 */
	public UserPostsDetails(User userDetails, List<Post> userPost) {
		this.userDetails = userDetails;
		this.userPost = userPost;
	}

	/**
	 * @return the userDetails
	 */
	public User getUserDetails() {
		return userDetails;
	}

	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}

	/**
	 * @return the userPost
	 */
	public List<Post> getUserPost() {
		return userPost;
	}

	/**
	 * @param userPost the userPost to set
	 */
	public void setUserPost(List<Post> userPost) {
		this.userPost = userPost;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserPostsDetails [userDetails=" + userDetails + ", userPost=" + userPost + "]";
	}
}
