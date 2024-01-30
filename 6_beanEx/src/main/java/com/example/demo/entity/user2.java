package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.util.abc;

import jakarta.annotation.PostConstruct;

@Service
public class user2 implements abc{

	private String name;
	
	@Value("${my.name:tea}")
	private String name2;
	
	@PostConstruct
	public void show() {
		name = "aaa";
	}
	
	@Override
	public void skill() {
		// TODO Auto-generated method stub
		System.out.println("user2 skill...name2=" + name2);
	}

}
