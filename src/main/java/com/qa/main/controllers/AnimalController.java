package com.qa.main.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.main.entities.Animal;
import com.qa.main.services.AnimalService;

@RestController
@RequestMapping("/animal")
public class AnimalController {

		private AnimalService service;
	
}
