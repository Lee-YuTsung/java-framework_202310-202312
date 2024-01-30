package com.example.demo.controller;

import java.awt.datatransfer.SystemFlavorMap;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;

@RestController
public class TestController {

	@RequestMapping("test1")
	public String get1(@RequestParam String name) {
		
		System.out.println("name: " + name);
		
		return "test1";
	}
	
	@RequestMapping("test2")
	public String get2(@RequestParam("name") String abc) {
		
		System.out.println("name: " + abc);
		
		return "test2";
	}
	
	@GetMapping("test3")
	public String get3(@RequestParam(value = "name", defaultValue = "teacher") String abc) {
		
		System.out.println("name: " + abc);
		
		return "test3";
	}
	
	@GetMapping("test4")
	public String get4(
			@RequestParam(value="name", defaultValue="john") String name,
			@RequestParam(value="age", defaultValue = "25") Integer age) {
		
		System.out.println("name: " + name + "\tage: " + age);
		
		return "test4";
	}
	@GetMapping("test5/{id}")
	public String get5(@PathVariable("id") Integer id) {
		
		System.out.println("id: " + id);
		
		return "test5";
	}
	
	@GetMapping("test6/{name}/{age}")
	public String get6(
			@PathVariable("name") String name,
			@PathVariable("age") Integer age) {
		
		System.out.println("name: " + name + "\tage: " + age);
		
		return "test6";
	}
	
	@GetMapping("test7")
	public String get7(@RequestBody User u) {
		
		System.out.println("user id:" + u.getId() + "\tuser name: " + u.getName());
		
		return "test7";
	}
}
