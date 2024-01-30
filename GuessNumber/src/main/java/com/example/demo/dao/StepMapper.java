package com.example.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Step;

@Mapper
public interface StepMapper {

	//create
	@Insert("insert into step(gid, times, input, output) values(#{gid, times, input, output)")
	void add(Step s);
	
	//read
	
}
