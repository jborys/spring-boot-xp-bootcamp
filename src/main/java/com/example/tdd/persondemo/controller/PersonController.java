package com.example.tdd.persondemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tdd.persondemo.exception.PersonRepositoryClientException;
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
	
	@GetMapping("/persons/search/findByFirstNameAndLastName")
	public ResponseEntity<?> findPersonByFirstNameAndLastName(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName){
		ResponseEntity<?> response; 
		try {
			response = ResponseEntity.ok(personRepository.findPersonByFirstNameAndLastName(firstName, lastName));
		} catch(PersonRepositoryClientException e) {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return response;
	}
		
}