package com.example.tdd.persondemo.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.tdd.persondemo.model.Person;
import com.example.tdd.persondemo.repository.PersonRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PersonController.class, secure=false)
public class TestPersonController {

	@MockBean
	private PersonRepository personRepo;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void successfulFindAllPersons() throws Exception {
		when(personRepo.findAll()).thenReturn(Arrays.asList(new Person(), new Person()));
		mockMvc.perform(get("/persons")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", hasSize(2)));
	}
}
