package com.example.tdd.persondemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.tdd.persondemo.exception.PersonRepositoryClientException;
import com.example.tdd.persondemo.model.Person;


public interface PersonRepository extends CrudRepository<Person, Long> {

	List<Person> findPersonByFirstNameAndLastName(String firstName, String lastName) throws PersonRepositoryClientException;

}
