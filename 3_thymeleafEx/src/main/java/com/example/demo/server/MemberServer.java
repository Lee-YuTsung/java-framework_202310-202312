package com.example.demo.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.mapper.MemberMapper;
import com.example.demo.model.Member;

public class MemberServer implements MemberMapper{

	@Autowired
	private MemberMapper mm;
	
	@Override
	public void add(Member m) {
		// TODO Auto-generated method stub
		if(mm.queryUsername(m.getUsername()) != null) {
			mm.add(m);
		}
	}

	@Override
	public Member queryUser(String username, String password) {
		// TODO Auto-generated method stub
		return mm.queryUser(username, password);
	}

	@Override
	public List<Member> queryAll() {
		// TODO Auto-generated method stub
		return mm.queryAll();
	}

	@Override
	public Member queryId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member queryUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMember(Member m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
