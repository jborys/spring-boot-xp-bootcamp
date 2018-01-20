package com.example.tdd.persondemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.tdd.persondemo.model.Person;


public interface PersonRepository extends CrudRepository<Person, Long> {

}
