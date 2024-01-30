package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Member;

@RestController
public class MemberController {

	@Autowired
	private JdbcTemplate jdbc;
	
	@RequestMapping("login")
	public ModelAndView login(String username, String password) {
		ModelAndView mav = null;
		
		String SQL = "select * from member where username = ? and password = ?";
		List<Member> members = jdbc.query(SQL,new BeanPropertyRowMapper(Member.class),username,password);
		
		return mav;
	}
	
	@RequestMapping("addMember")
	public String addMember(String name, String username, String password, 
			String address, String phone, String mobile) {
		ModelAndView mav = null;
		
		String SQL = "insert into "
				+ "member(name, username, passowrd, address, phone, mobile) "
				+ "value(?, ?, ?, ?, ?, ?)";
		jdbc.update(SQL, name, username, password, address, phone, mobile);
		
		mav = new ModelAndView("addMemberSuccess");
		
		return "addMemberSuccess";
	}
	
	@RequestMapping("update")
	public String updateMember(Member m) {
		
		String SQL = "update member set "
				+ "name = ?, password = ?, address = ?, mobile = ? "
				+ "where id =?;";
		jdbc.update(SQL, m.getName(), m.getUsername(), m.getPassword(), 
				m.getAddress(), m.getMobile(), m.getId());
		
		return "updateSuccess";
	}
	
	@RequestMapping("delete")
	public String deleteMember(Integer id) {
		
		String SQL = "delete from member where id = ?";
		jdbc.update(SQL, id);
		
		return "deleteSuccess";
	}
	
	@RequestMapping("queryAll")
	public void queryAll() {
		String SQL = "select * from member";
		List<Member> members = jdbc.query(SQL, new BeanPropertyRowMapper(Member.class)); 
		
	}
	
}
