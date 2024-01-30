package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.user1;
import com.example.demo.entity.user2;
import com.example.demo.util.abc;

@Configuration
public class FactCon {

	@Bean
	public abc get1() {
		
		return new user1();
	}
	
	@Bean
	public abc get2() {
		return new user2();
	}
}
