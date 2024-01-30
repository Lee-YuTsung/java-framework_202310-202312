package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping("exam1")
	public String getExam1(Model model) {
		
		String companyName = "巨匠電腦";
		model.addAttribute("companyName", companyName);
		
		return "exam1";
	}
	
	@RequestMapping("exam2")
	public ModelAndView getExam2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("exam2");
		
		return mv;
	}
}
