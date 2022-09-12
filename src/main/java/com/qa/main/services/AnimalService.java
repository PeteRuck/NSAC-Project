package com.qa.main.services;

import org.springframework.stereotype.Service;

import com.qa.main.entities.Animal;
import com.qa.main.repos.AnimalRepo;

@Service
public class AnimalService {

	private AnimalRepo repo;

	public AnimalService(AnimalRepo repo) {
		super();
		this.repo = repo;
	}

	public Animal create(Animal input) {
		return repo.saveAndFlush(input);
	}
	
	
	
}
