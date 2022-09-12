package com.qa.main.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	//	Post Requests (CREATE)
	@PostMapping("/create")
	public ResponseEntity<Animal> create(@RequestBody Animal input) {
			return new ResponseEntity <Animal>(service.create(input), HttpStatus.CREATED);
	}
	
}
