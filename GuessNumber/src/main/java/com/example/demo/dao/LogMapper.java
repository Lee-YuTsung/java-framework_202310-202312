package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.Log;

@Mapper
public interface LogMapper {

	//create
	@Insert("insert into log(play, target, times) values(#{play}, #{target}, #{times})")
	void add(Log l);
	
	//read
	@Select("select * from log")
	List<Log> logs();
	
}
