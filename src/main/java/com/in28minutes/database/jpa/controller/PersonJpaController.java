package com.in28minutes.database.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.database.jpa.model.PersonEntity;
import com.in28minutes.database.jpa.repository.PersonJpaRepository;

@RestController
@RequestMapping("/jpa/people")
public class PersonJpaController {
	
	private PersonJpaRepository repository;

	@Autowired
	public PersonJpaController(PersonJpaRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<PersonEntity> findAll() {
		return this.repository.findAll();
	}

	@GetMapping("/{id}")
	public PersonEntity findById(@PathVariable Integer id) {
		return this.repository.findById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Integer id) {
		this.repository.deleteById(id);
	}

	@GetMapping("/name/{name}")
	public List<PersonEntity> findByName(@PathVariable String name) {
		return this.repository.findByName(name);
	}

	@GetMapping("/location/{location}")
	public List<PersonEntity> findByLocation(@PathVariable String location) {
		return this.repository.findByLocation(location);
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void insert(@RequestBody PersonEntity person) {
		this.repository.insert(person);
	}

	@PutMapping
	@ResponseStatus(value = HttpStatus.OK)
	public void update(@RequestBody PersonEntity person) {
		this.repository.update(person);
	}

	@GetMapping("/count")
	public Integer count() {
		return this.repository.count();
	}
}