package com.Matheusgabriel1234.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Matheusgabriel1234.workshop.domain.User;
import com.Matheusgabriel1234.workshop.dto.UserDTO;
import com.Matheusgabriel1234.workshop.repository.UserRepository;
import com.Matheusgabriel1234.workshop.service.exception.ObjectNotFound;
import com.mongodb.DuplicateKeyException;

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
		try {
			return repo.save(obj);
		}catch(DuplicateKeyException e){
      throw new IllegalArgumentException("Esse email ja foi cadastrado", e);			
		}
		
	
	}
	
	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(),obj.getEmail(),obj.getSenha(),obj.getUsername());
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	
	public User update(User obj) {
		User newObj = repo.findById(obj.getId()).orElse(null);
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	private void updateData(User newObj,User obj) {
		newObj.setEmail(obj.getEmail());
		newObj.setPassword(obj.getPassword());
		newObj.setUsername(obj.getUsername());
	}
	

}
