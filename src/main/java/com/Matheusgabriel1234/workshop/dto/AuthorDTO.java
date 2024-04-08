package com.Matheusgabriel1234.workshop.dto;

import java.io.Serializable;

import com.Matheusgabriel1234.workshop.domain.User;

public class AuthorDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String Id;
	
	private String username;
	
	public AuthorDTO() {
		
	}
	
	public AuthorDTO(User obj) {
		Id = obj.getId();
		username = obj.getUsername();
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}
