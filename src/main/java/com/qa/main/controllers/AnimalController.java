package com.qa.main.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.main.entities.Animal;
import com.qa.main.services.AnimalService;

@RestController
@RequestMapping("/animal")
public class AnimalController {

		private AnimalService service;
	
		public AnimalController(AnimalService service) {
			super();
			this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Animal> create(@RequestBody Animal input) {
			return new ResponseEntity <Animal>(service.create(input), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll") 
	public List<Animal> getAll() {
			return service.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public Animal getById(@PathVariable long id) {
			return service.getById(id);
	}
	
	@GetMapping("/getByTypeGenus/{typeGenus}")
	public List<Animal> getByTypeGenus(@PathVariable String typeGenus) {
			return service.getByTypeGenus(typeGenus);
	}
			
}
