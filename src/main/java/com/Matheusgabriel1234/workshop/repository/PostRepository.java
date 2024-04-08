package com.Matheusgabriel1234.workshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Matheusgabriel1234.workshop.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
