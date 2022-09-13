package com.qa.main.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.entities.Animal;
import com.qa.main.services.AnimalService;

@WebMvcTest
public class AnimalControllerUnitTest {

	@Autowired
	private MockMvc mvc; 
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private AnimalService service;
	
	@Test
	public void createTest() throws Exception {
		Animal input = new Animal("Fox", "Vulpes", 50, "Canidae");
		String inputAsJSON = mapper.writeValueAsString(input);
		
		Animal response = new Animal(2L, "Fox", "Vulpes", 50, "Canidae");
		String responseAsJSON = mapper.writeValueAsString(response);
		
		Mockito.when(service.create(input)).thenReturn(response); 
		
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
		
		Mockito.when(service.getAll()).thenReturn(result);
		
		mvc.perform(get("/animal/getAll")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByIdTest() throws Exception {
		Animal result = new Animal(1L, "Fox", "Vulpes", 50, "Canidae");
		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.getById(1L)).thenReturn(result);
		
		mvc.perform(get("/animal/getById/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByTypeGenusTest() throws Exception {
		List<Animal> result = new ArrayList<>();
		result.add(new Animal(1L, "Fox", "Vulpes", 50, "Canidae"));
		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.getByTypeGenus("Canidae")).thenReturn(result);
		
		mvc.perform(get("/animal/getByTypeGenus/Canidae")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(resultAsJSON));		
	}
	
	@Test
	public void getByCommonNameContainingTest() throws Exception {
		List<Animal> result = new ArrayList<>();
		result.add(new Animal(1L, "Fox", "Vulpes", 50, "Canidae"));
		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.getByCommonNameContaining("Fox")).thenReturn(result);
		
		mvc.perform(get("/animal/getByCommonNameContaining/Fox")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void updateTest() throws Exception {
		Animal update = new Animal("Wolf", "Vulpes", 90, "Canidae"); // Updated info to main entry (body of request)
		String updateAsJSON = mapper.writeValueAsString(update);
		
		Animal response = new Animal(1L, "Wolf", "Vulpes", 90, "Canidae"); // Expected result (for checking response)
		String responseAsJSON = mapper.writeValueAsString(response);
		
		Mockito.when(service.update(1L, update)).thenReturn(response);
		
		mvc.perform(put("/animal/update/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(updateAsJSON))
			.andExpect(status().isOk())
			.andExpect(content().json(responseAsJSON));
	
	}
	
	
}
