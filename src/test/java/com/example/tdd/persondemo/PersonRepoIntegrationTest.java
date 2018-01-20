package com.example.tdd.persondemo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.tdd.persondemo.exception.PersonRepositoryClientException;
import com.example.tdd.persondemo.model.Person;
import com.example.tdd.persondemo.repository.PersonRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepoIntegrationTest {

	@Autowired
	PersonRepository personRepo;
	
	@After
    public void tearDown() throws Exception {
		personRepo.deleteAll();
    }
	
	@Test
	public void saveAndFetchPerson() throws PersonRepositoryClientException	  {
		//Arrange
		Person scott = new Person.PersonBuilder("Scott", "Smith").build();
		
		//Act
		personRepo.save(scott);
		Person maybeScott = personRepo.findOne(scott.getId());
		
		//Assert
		assertThat(maybeScott, is(equalTo((scott))));
	}
}
