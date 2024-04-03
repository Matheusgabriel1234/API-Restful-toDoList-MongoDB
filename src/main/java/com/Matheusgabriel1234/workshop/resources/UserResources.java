package com.Matheusgabriel1234.workshop.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Matheusgabriel1234.workshop.domain.User;
import com.Matheusgabriel1234.workshop.service.UserService;

@RestController
@RequestMapping("/users")
public class UserResources {

	@Autowired
	private UserService serv;
	
	@GetMapping
	
	public ResponseEntity<List<User>> findAll(){
		List<User> list = serv.findAll();
		User matheus = new User(null,"Matheusgabriel1234","aaaaaaaaaaaaaaa@aaa.com","**********");
		User luiza = new User(null,"LuizaGrando1234","aaaaaaaaa21aaaaaa@aaa.com","**********");
		
		list.addAll(Arrays.asList(matheus,luiza));
		return ResponseEntity.ok().body(list);
	}
}
