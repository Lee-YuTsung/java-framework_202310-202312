package com.example.demo.Entity;

import lombok.Data;

@Data
public class Bank {

	private Integer id;
	private String name;
	private Integer balance;

	public Bank(String name, Integer balance) {
		super();
		this.name = name;
		this.balance = balance;
	}

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
