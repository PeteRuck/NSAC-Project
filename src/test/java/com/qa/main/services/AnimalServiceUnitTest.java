package com.qa.main.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	@Test
	public void getAllTest() {
		List<Animal> result = new ArrayList<>();
		result.add(new Animal(1L, "Fox", "Vulpes", 50, "Canidae"));
		
		
		Mockito.when(repo.findAll()).thenReturn(result);
		
		assertEquals(result, service.getAll());
	}
	
	@Test
	public void getByIdTest() {
		Optional<Animal> OptionalOutput = Optional.of(new Animal(1L,"Fox", "Vulpes", 50, "Canidae"));
		Animal output = new Animal(1L, "Fox", "Vulpes", 50, "Canidae");
	
	
		Mockito.when(repo.findById(1L)).thenReturn(OptionalOutput);
		
		assertEquals(output, service.getById(1L));
	}
		
	@Test
	public void getByTypeGenusTest() {
		List<Animal> result = new ArrayList<>();
		result.add(new Animal("Fox", "Vulpes", 50, "Canidae"));
		
		Mockito.when(repo.findAnimalByTypeGenus("Canidae")).thenReturn(result);
		
		assertEquals(result, service.getByTypeGenus("Canidae"));
	}
		
	@Test
	public void getByCommonNameContaining() {
		List<Animal> result = new ArrayList<>();
		result.add(new Animal("Fox", "Vulpes", 50, "Canidae"));
		
		Mockito.when(repo.findByCommonNameContaining("Fox")).thenReturn(result);
		
		assertEquals(result, service.getByCommonNameContaining("Fox"));
	}
		
	
}
