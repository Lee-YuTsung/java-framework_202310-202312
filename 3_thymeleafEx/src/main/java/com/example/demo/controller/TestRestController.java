package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.mapper.MemberMapper;
import com.example.demo.model.Member;
import com.example.demo.model.User;

import jakarta.servlet.http.HttpSession;

@RestController
public class TestRestController {

	@Autowired
	private MemberMapper mm;
	@Autowired
	private HttpSession session;
	
	@RequestMapping("e1")
	public String exam1() {
		return "exam1";
	}
	
	@RequestMapping("ex1")
	public ModelAndView exam1_2() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("exam1");
		
		return mv;
	}
	
	@RequestMapping("exam3")
	public ModelAndView exam3(Model model) {
		
		String name = "巨匠電腦教育中心";
		model.addAttribute("name", name);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("exam3");
		
		User user = new User(1, "Rock", 30);
		mv.addObject("user", user);
		
		return mv;
	}
	
	@RequestMapping("exam4")
	public ModelAndView exam4() {
		
		List<User> users = new ArrayList<>();
		users.add(new User(1, "a", 25));
		users.add(new User(2, "b", 18));
		users.add(new User(3, "c", 40));
		users.add(new User(4, "d", 13));
		
		ModelAndView mav = new ModelAndView("exam4");
		mav.addObject("list", users);
		
		return mav;
	}
	
	@RequestMapping("exam5")
	public ModelAndView exam5(Model model) {
		
		List<Member> members = mm.queryAll();
		
		model.addAttribute("memberData", "會員基本資料");
		
		ModelAndView mav = new ModelAndView("exam5");
		mav.addObject("members", members);
		
		return mav;
	}
	
	@RequestMapping("login")
	public ModelAndView login(String username, String password) {
		
		ModelAndView mav = null;
		
		Member user = mm.queryUser(username, password);
		
		if(user != null) {
			session.setAttribute("user", user);
			mav = new ModelAndView("loginSuccess");
		}else {
			mav = new ModelAndView("loginError");
		}
		
		return mav;
	}
}
