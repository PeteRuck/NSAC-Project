package com.qa.main.services;

import java.util.List;
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
	
	public List<Animal> getAll() {
		return repo.findAll();
	}
	
	public Animal getById(long id) {
		return repo.findById(id).get();
	}
	
	public List<Animal> getByTypeGenus(String typeGenus) {
			return repo.findAnimalByTypeGenus(typeGenus);
	}
	
	public List<Animal> getByCommonNameContaining(String commonName) {
			return repo.findByCommonNameContaining(commonName);
	}
	
	public Animal update(long id, Animal input) {
		Animal existing = repo.findById(id).get();
		
		existing.setCommonName(input.getCommonName());
		existing.setGenus(input.getGenus());
		existing.setSize(input.getSize());
		existing.setTypeGenus(input.getTypeGenus());
		
		return repo.saveAndFlush(existing);
	}
	
	
	
}
