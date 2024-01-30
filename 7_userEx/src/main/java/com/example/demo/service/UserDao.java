package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserDao {

	void add(User u);
	
	List<User> findAll();
}
