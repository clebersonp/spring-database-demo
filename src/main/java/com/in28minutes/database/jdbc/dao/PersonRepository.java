package com.in28minutes.database.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.jdbc.model.Person;

@Repository
public class PersonRepository {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public PersonRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Person> findAll() {
		return this.jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
	}
}