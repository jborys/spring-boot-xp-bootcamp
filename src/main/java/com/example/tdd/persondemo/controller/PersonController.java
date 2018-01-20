package com.example.tdd.persondemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tdd.persondemo.model.Person;
import com.example.tdd.persondemo.repository.PersonRepository;

@RestController
public class PersonController {

	private PersonRepository personRepository;

	public PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@GetMapping("/persons")
	public ResponseEntity<Iterable<Person>> findAllCustomers(){
		return ResponseEntity.ok(personRepository.findAll());
	}
		
}