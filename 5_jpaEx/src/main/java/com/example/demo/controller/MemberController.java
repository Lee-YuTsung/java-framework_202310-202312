package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberRepository mr;
	@Autowired
	private HttpSession session;

	@GetMapping("add")
	public ModelAndView add() {
		return new ModelAndView("/addMember");
	}
	
	@PostMapping("add")
	public ModelAndView add(String name, String username, String password, 
			String address, String phone, String mobile) {
		
		ModelAndView mav = new ModelAndView();
		if(mr.findByUsername(username) == null && 
				nonull(name, username, password, address, phone, mobile)) {
			Member m = new Member();
			m.setName(name);
			m.setUsername(username);
			m.setPassword(password);
			m.setAddress(address);
			m.setPhone(phone);
			m.setMobile(mobile);
			
			mr.save(m);
			mav.setViewName("/addMemberSuccess");
			mav.addObject("m", m);
			
			return mav;
		}else {
			mav.setViewName("/addMemberError");
			return mav;
		}
		
	}
	
	@RequestMapping("queryAll")
	public List<Member> queryAll(){
		
		return mr.findAll();
	}
	
	@RequestMapping("queryId")
	public Member queryId(Integer id) {
		
		Optional<Member> o = mr.findById(id);
		
		Member m = o.isPresent() ? o.get() : null;
		
		return m;
		//return mr.getReferenceById(id);
	}
	
	@RequestMapping("update")
	public ModelAndView update(Integer id, String name, String password, 
			String address, String phone, String mobile) {
		Member m = queryId(id);
		if(m != null) {
			m.setName(name != "" && name != null ? name : m.getName());
			m.setPassword(password != "" && password != null ? password : m.getPassword());
			m.setAddress(address != "" && address != null ? address : m.getAddress());
			m.setPhone(phone != "" && phone != null ? phone : m.getPhone());
			m.setMobile(mobile != "" && mobile != null ? mobile : m.getMobile());
			
			mr.save(m);
			
			return new ModelAndView("/updateMemberSuccess");
		}
		
		return new ModelAndView("/updateMemberError");
	}
	
	@RequestMapping("delete")
	public ModelAndView delete(Integer id) {
		
		if(queryId(id) != null) {
			mr.deleteById(id);
			
			return new ModelAndView("/deleteSuccess");
		}
		
		return new ModelAndView("/deleteError");
	}
	
	@RequestMapping("jpqlQueryUser")
	public Member jpqlQueryUser(String username, String password) {
		return mr.jpqlQueryUser(username, password);
	}
	
	@RequestMapping("sqlQueryUser")
	public Member sqlQueryUser(String username, String password) {
		return mr.sqlQueryUser(username, password);
	}
	
	@RequestMapping("login")
	public ModelAndView login(String username, String password) {
		
		ModelAndView mav = new ModelAndView();
		Member m = mr.sqlQueryUser(username, password);
		
		if(m != null) {
			session.setAttribute("user", m);
			
			mav.setViewName("/loginSuccess");
		}else {
			mav.setViewName("/loginError");
		}
		
		return mav;
	}
	
	@RequestMapping("memberCRUD")
	public ModelAndView memberCRUD() {
		ModelAndView mav = new ModelAndView("/member/memberCRUD");
		
		mav.addObject("members", queryAll());
		
		return mav;
	}
	
	private boolean nonull(String... args) {
		return Arrays.asList(args).stream().allMatch(e -> e != null && e != "");
	}
}
