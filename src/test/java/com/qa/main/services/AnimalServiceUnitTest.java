package com.qa.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.main.repos.AnimalRepo;

@SpringBootTest
public class AnimalServiceUnitTest {

	@Autowired
	private AnimalService service;
	
	@MockBean
	private AnimalRepo repo;
		
	
	
}
