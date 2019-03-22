package com.in28minutes.database.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.database.jdbc.dao.PersonRepository;
import com.in28minutes.database.jdbc.model.Person;

@RestController
@RequestMapping("/jdbc/people")
public class PersonController {
	
	private PersonRepository repository;

	@Autowired
	public PersonController(PersonRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Person> findAll() {
		return this.repository.findAll();
	}

	@GetMapping("/{id}")
	public Person findById(@PathVariable Integer id) {
		return this.repository.findById(id);
	}

	@GetMapping("/name/{name}")
	public List<Person> findByName(@PathVariable String name) {
		return this.repository.findByName(name);
	}

	@GetMapping("/location/{location}")
	public List<Person> findByLocation(@PathVariable String location) {
		return this.repository.findByLocation(location);
	}

	@GetMapping("/count")
	public Integer count() {
		return this.repository.count();
	}
}