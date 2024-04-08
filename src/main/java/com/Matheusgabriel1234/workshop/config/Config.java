package com.Matheusgabriel1234.workshop.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.Matheusgabriel1234.workshop.domain.Post;
import com.Matheusgabriel1234.workshop.domain.User;
import com.Matheusgabriel1234.workshop.dto.AuthorDTO;
import com.Matheusgabriel1234.workshop.repository.PostRepository;
import com.Matheusgabriel1234.workshop.repository.UserRepository;

@Configuration
public class Config implements CommandLineRunner{
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	@Autowired
	private PostRepository postrepo;
	
	@Autowired
	private UserRepository repo;

	@Override
	public void run(String... args) throws Exception {
		repo.deleteAll();
		postrepo.deleteAll();
		
		
		User matheus = new User(null,"matheus@example.com","matheus122313","Matheusgabriel1234");

		User luiza = new User(null,"luiza@example.com","luiza122313","LuizaGrando1234");
		

		User eduarda = new User(null,"eduarda@example.com","eduarda122313","EduardaCcato1234");
		repo.saveAll(Arrays.asList(matheus,luiza,eduarda));
	
		
		Post post1 = new Post(null,"Estudos de programação", "Hoje devo estudar no minimo 4 horas de programação",sdf.parse("08/04/2024"), new AuthorDTO(eduarda));
		
		Post post2 = new Post(null,"Estudos de Psicologia", "Hoje devo estudar no minimo 4 horas de psicologia",sdf.parse("09/04/2024"),new AuthorDTO(matheus));

	  matheus.getPost().addAll(Arrays.asList(post1));
	  eduarda.getPost().addAll(Arrays.asList(post2));
	  postrepo.saveAll(Arrays.asList(post1,post2));
	  
		
		
	}

}
