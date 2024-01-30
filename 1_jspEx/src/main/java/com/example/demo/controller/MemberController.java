package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.mapper.MemberMapper;
import com.example.demo.model.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberMapper mm;

	/*
	@RequestMapping("hello")
	public ModelAndView getHello() {
		ModelAndView mv = new ModelAndView("hello");
		
		return mv;
	}
	*/
	
	@RequestMapping("addMember")
	public String addMember(String name, String username, String password, 
			String address, String phone, String mobile) {
		
		Member m = new Member(name, username, password, address, phone, mobile);
		mm.add(m);
		
		return "addMemberSuccess";
	}
	
	@RequestMapping("login")
	public String login(String username, String password) {
		Member m = mm.queryUser(username, password);
		if(m != null) {
			return "loginSuccess";
			
		}else {
			return "loginError";
		}
	}
}
