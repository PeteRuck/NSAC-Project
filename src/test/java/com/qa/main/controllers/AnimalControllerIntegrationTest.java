package com.qa.main.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.entities.Animal;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class AnimalControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void createTest() throws Exception {
		Animal input = new Animal("Fox", "Vulpes", 50, "Canidae");
		String inputAsJSON = mapper.writeValueAsString(input);
		
		Animal response = new Animal(2L, "Fox", "Vulpes", 50, "Canidae");
		String responseAsJSON = mapper.writeValueAsString(response);
		
		mvc.perform(post("/animal/create")
			.contentType(MediaType.APPLICATION_JSON)
			.content(inputAsJSON))
			.andExpect(status().isCreated())
			.andExpect(content().json(responseAsJSON));
	}
	
	@Test
	public void getAllTest() throws Exception {
		List<Animal> result = new ArrayList<>();
		result.add(new Animal(1L, "Fox", "Vulpes", 50, "Canidae"));
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/animal/getAll")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByIdTest() throws Exception {
		Animal result = new Animal(1L, "Fox", "Vulpes", 50, "Canidae");
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/animal/getById/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(resultAsJSON));
	}
	
}
