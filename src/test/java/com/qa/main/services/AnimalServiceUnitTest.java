package com.qa.main.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.main.entities.Animal;
import com.qa.main.repos.AnimalRepo;

@SpringBootTest
public class AnimalServiceUnitTest {

	@Autowired
	private AnimalService service;
	
	@MockBean
	private AnimalRepo repo;
		
	@Test
	public void createTest() {
		// Create an object for saving
		Animal input = new Animal("Fox", "Vulpes", 50, "Canidae");
		
		// Create an object for the result
		Animal result = new Animal(2L, "Fox", "Vulpes", 50, "Canidae");
		
		Mockito.when(repo.saveAndFlush(input)).thenReturn(result);
		
		// assertEquals(expected result, actual result)
		assertEquals(result, service.create(input));
	}
	
	
	
}
