package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserDao;

@Service
public class UserDaoImpl implements UserDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Autowired
	private UserRepository ur;
	
	@Override
	public void add(User u) {
		// TODO Auto-generated method stub
		ur.save(u);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}

}
