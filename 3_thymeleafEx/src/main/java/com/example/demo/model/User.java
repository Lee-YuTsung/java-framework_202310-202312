package com.example.demo.model;

import lombok.Data;

@Data
public class User {

	private Integer id;
	private String name;
	private Integer age;
	
	public User(Integer id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
