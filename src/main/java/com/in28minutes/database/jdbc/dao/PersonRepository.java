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
		return this.jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
	}

	public Person findById(Integer id) {
		return this.jdbcTemplate.queryForObject("select * from person where id = ?", new Object[] { id },
				new BeanPropertyRowMapper<>(Person.class));
	}

	public List<Person> findByName(String name) {
		return this.jdbcTemplate.query("select * from person where lower(name) like ?", new Object[] { "%" + name.toLowerCase() + "%" },
				new BeanPropertyRowMapper<>(Person.class));
	}

	public List<Person> findByLocation(String location) {
		return this.jdbcTemplate.query("select * from person where lower(location) like ?", new Object[] { "%" + location.toLowerCase() + "%" },
				new BeanPropertyRowMapper<>(Person.class));
	}

	public Integer count() {
		return this.jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class)).size();
	}
}