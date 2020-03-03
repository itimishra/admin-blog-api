package com.spring.adminblogapi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {
	
	private String name;
	private String catchPhrase;
	private String bs;
	
	/**
	 * Default Constructor
	 */
	public Company() {
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the catchPhrase
	 */
	public String getCatchPhrase() {
		return catchPhrase;
	}

	/**
	 * @param catchPhrase the catchPhrase to set
	 */
	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}

	/**
	 * @return the bs
	 */
	public String getBs() {
		return bs;
	}

	/**
	 * @param bs the bs to set
	 */
	public void setBs(String bs) {
		this.bs = bs;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Company [name=" + name + ", catchPhrase=" + catchPhrase + ", bs=" + bs + "]";
	}
}
