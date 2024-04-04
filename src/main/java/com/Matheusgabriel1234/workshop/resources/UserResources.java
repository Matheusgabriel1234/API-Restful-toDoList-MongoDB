package com.Matheusgabriel1234.workshop.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Matheusgabriel1234.workshop.domain.User;
import com.Matheusgabriel1234.workshop.dto.UserDTO;
import com.Matheusgabriel1234.workshop.service.UserService;

@RestController
@RequestMapping("/users")
public class UserResources {

	@Autowired
	private UserService serv;
	
	@GetMapping
	
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = serv.findAll();
		List <UserDTO> listDTO = list.stream().map(UserDTO::new).collect(Collectors.toList());

		
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User obj = serv.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
		
	}
}
