package com.Matheusgabriel1234.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Matheusgabriel1234.workshop.domain.User;
import com.Matheusgabriel1234.workshop.repository.UserRepository;
import com.Matheusgabriel1234.workshop.service.exception.ObjectNotFound;

@Service
public class UserService {

	
	@Autowired
	UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
	User user = repo.findById(id).orElse(null);
	if(user == null) {
		throw new ObjectNotFound("Objeto não encontrado");
	}
	return user;
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
}
