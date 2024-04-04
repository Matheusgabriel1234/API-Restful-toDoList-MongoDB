package com.Matheusgabriel1234.workshop.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="User")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
private String id;
	@Indexed(unique=true)
private String email;
private String password;
private String username;

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public User() {
	
}

public User(String id, String email, String password,String username) {
	super();
	this.username = username;
	this.id = id;
	this.email = email;
	this.password = password;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public int hashCode() {
	return Objects.hash(password);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return Objects.equals(password, other.password);
}


}
