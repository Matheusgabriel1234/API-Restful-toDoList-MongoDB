package com.Matheusgabriel1234.workshop.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.Matheusgabriel1234.workshop.domain.User;
import com.Matheusgabriel1234.workshop.repository.UserRepository;

@Configuration
public class Config implements CommandLineRunner{
	
	@Autowired
	private UserRepository repo;

	@Override
	public void run(String... args) throws Exception {
		repo.deleteAll();
		
		User matheus = new User(null,"matheus@example.com","matheus122313","Matheusgabriel1234");

		User luiza = new User(null,"luiza@example.com","luiza122313","LuizaGrando1234");
		

		User eduarda = new User(null,"eduarda@example.com","eduarda122313","EduardaCcato1234");
		
		repo.saveAll(Arrays.asList(matheus,luiza,eduarda));
	}

}
