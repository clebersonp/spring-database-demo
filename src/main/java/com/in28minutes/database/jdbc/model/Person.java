package com.in28minutes.database.jdbc.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Person {
	private Integer id;
	private String name;
	private String location;
	private LocalDateTime birthDate;
}