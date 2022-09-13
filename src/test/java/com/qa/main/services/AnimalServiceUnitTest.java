package com.qa.main.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
		
	@Test
	public void updateTest() {
		Animal input = new Animal("Fox", "Vulpes", 50, "Canidae");
		Optional<Animal> existing = Optional.of(new Animal(1L, "Fox", "Vulpes", 50, "Canidae"));
		Animal output = new Animal(1L, "Fox", "Vulpes", 50, "Canidae");
		
		Mockito.when(this.repo.findById(1L)).thenReturn(existing);
		Mockito.when(this.repo.saveAndFlush(output)).thenReturn(output);
		
		assertEquals(output, this.service.update(1L, input));
	}

	@Test
	public void deleteTrueTest() {
		Mockito.when(this.repo.existsById(1L)).thenReturn(false);
		
		assertTrue(this.service.delete(1L));
	}
	
	@Test
	public void deleteFalseTest() {
		Mockito.when(this.repo.existsById(1L)).thenReturn(true);
		
		assertFalse(this.service.delete(1L));
	}	
}