package com.Matheusgabriel1234.workshop.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.Matheusgabriel1234.workshop.dto.AuthorDTO;

@Document(collection="Post")
public class Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	private String title;
	private String text;
    private Date date;
    private AuthorDTO author;
	

    public Post() {
    	
    }

    
    





	public Post(String id, String title, String text, Date date, AuthorDTO author) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
		this.date = date;
		this.author = author;
	}








	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}




	public AuthorDTO getAuthor() {
		return author;
	}




	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}




	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}
    
    
    
}
