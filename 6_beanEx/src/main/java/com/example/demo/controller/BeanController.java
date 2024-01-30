package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.FactCon;
import com.example.demo.entity.user1;
import com.example.demo.entity.user2;
import com.example.demo.util.abc;

@RestController
public class BeanController {

	@Autowired
	user1 us1;
	@Autowired
	user2 us2;
	
	@Autowired
	@Qualifier("user1")
	abc a;
	
	@Autowired
	FactCon fc;
	
	@RequestMapping("test1")
	public String get1() {
		us1.skill();
		return "us1 success";
	}
	
	@RequestMapping("test2")
	public String get2() {
		us2.skill();
		return "us2 success";
	}
	
	@RequestMapping("testa")
	public String geta() {
		a.skill();
		return "a success";
	}
	
	@RequestMapping("testfc")
	public String getfc() {
		fc.get1().skill();
		return "fc success";
	}
}
