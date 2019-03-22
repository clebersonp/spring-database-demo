package com.in28minutes.database.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.database.jdbc.dao.PersonRepository;
import com.in28minutes.database.jdbc.model.Person;

@RestController
@RequestMapping("/jdbc")
public class PersonController {
	
	private PersonRepository repository;

	@Autowired
	public PersonController(PersonRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/people")
	public List<Person> findAll() {
		return this.repository.findAll();
	}
}