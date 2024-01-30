package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.Bank;
import com.example.demo.mapper.BankMapper;
import com.example.demo.service.BankService;

@Service
public class BankServiceImpl implements BankService{

	@Autowired
	private BankMapper bm;

	@Transactional(rollbackFor = {Exception.class})
	@Override
	public void transfer(Integer fromId, Integer toId, Integer money) {
		// TODO Auto-generated method stub
		bm.decreaseMoney(money, fromId);
		int x = 10 / 0;
		bm.addMoney(money, toId);
	}

}
