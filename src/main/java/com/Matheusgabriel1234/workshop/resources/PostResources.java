package com.Matheusgabriel1234.workshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Matheusgabriel1234.workshop.domain.Post;
import com.Matheusgabriel1234.workshop.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostResources {

	@Autowired
	private PostService serv;
	
	@GetMapping
	 public ResponseEntity<List<Post>> findAll() {
	        List<Post> posts = serv.findAll(); 
	        return ResponseEntity.ok().body(posts);
	    }
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = serv.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
