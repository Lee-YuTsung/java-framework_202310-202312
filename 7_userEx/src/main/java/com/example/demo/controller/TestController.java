package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.impl.UserDaoImpl;

@RestController
public class TestController {

	@Autowired
	private UserDaoImpl ud;
	
	@PostMapping("add")
	public String add(String name, Integer age) {
		
		User u = new User(name, age);
		ud.add(u);
		
		return "add success";
	}
	
	@GetMapping("queryAll")
	public List<User> queryAll(){
		return ud.findAll();
	}
}
