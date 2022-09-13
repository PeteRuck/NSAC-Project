package com.qa.main.entities;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AnimalTest {
	
	@Test
	public void equalsNullTest() {
		Animal animal = new Animal("Fox", "Vulpes", 50, "Canidae");
		
		assertFalse(animal.equals(null));
	}
	
	@Test
	public void differentClassTest() {
		Animal animal = new Animal("Fox", "Vulpes", 50, "Canidae");
		String testString = "Hi";
		
		assertFalse(animal.equals(testString));
	}
	
	@Test
	public void checkHashTest() {
		Animal one = new Animal("Fox", "Vulpes", 50, "Canidae");
		Animal two = new Animal("Fox", "Vulpes", 50, "Canidae");
		
		assertTrue(one.hashCode() == two.hashCode());
	}	
}
