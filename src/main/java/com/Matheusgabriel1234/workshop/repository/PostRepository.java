package com.Matheusgabriel1234.workshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Matheusgabriel1234.workshop.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
