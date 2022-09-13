package com.qa.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.services.AnimalService;

@WebMvcTest
public class AnimalControllerUnitTest {

	@Autowired
	private MockMvc mvc; // This is for sending mock requests
	
	@Autowired
	private ObjectMapper mapper; // Is for converting TO and FROM JSON data
	
	@MockBean
	private AnimalService service;
		
	
	
	
}
