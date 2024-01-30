package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.Entity.Bank;

@Mapper
public interface BankMapper {

	//create
	
	//read
	
	//update
	@Update("update bank set balance = balance - #{balance} where id = #{id}")
	void decreaseMoney(Integer balance, Integer id);
	@Update("update bank set balance = balance + #{balance} where id = #{id}")
	void addMoney(Integer balance, Integer id);
	
	//delete
}
