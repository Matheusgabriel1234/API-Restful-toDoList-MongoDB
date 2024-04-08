package com.Matheusgabriel1234.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Matheusgabriel1234.workshop.domain.Post;
import com.Matheusgabriel1234.workshop.repository.PostRepository;
import com.Matheusgabriel1234.workshop.service.exception.ObjectNotFound;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
	Post post = repo.findById(id).orElse(null);
	if(post  == null) {
		throw new ObjectNotFound("Objeto não encontrado");
	}
	return post;
	}
	
	  public List<Post> findAll() {
	        return repo.findAll();
	    }

}
