package com.Matheusgabriel1234.workshop.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Matheusgabriel1234.workshop.domain.User;
import com.Matheusgabriel1234.workshop.dto.UserDTO;
import com.Matheusgabriel1234.workshop.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;


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
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
		User obj = serv.fromDTO(objDto);
		obj = serv.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		serv.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO objDTO){
		User obj = serv.fromDTO(objDTO);
		obj.setId(id);
		obj = serv.update(obj);
		return ResponseEntity.noContent().build();
	}
	
}
