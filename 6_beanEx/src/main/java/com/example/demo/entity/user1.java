package com.example.demo.entity;

import org.springframework.stereotype.Component;

import com.example.demo.util.abc;

@Component//元件
public class user1 implements abc{

	private String name;
	
	public user1(String name) {
		super();
		this.name = name;
	}

	public user1() {
		super();
		name = "aaa";
	}

	@Override
	public void skill() {
		// TODO Auto-generated method stub
		System.out.println("user1 skill... name = " + name);
	}

}
