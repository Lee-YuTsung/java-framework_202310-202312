package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Member;

public interface MemberDao {

	//create
	void add(Member m);
	
	//read
	List<Member> queryAll();
	Member queryId(Integer id);
	boolean queryUsername(String username);
	Member queryUser(String username, String password);
	
	//update
	void update(Member m);
	
	//delete
	void delete(Integer id);
}
