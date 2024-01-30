package com.example.demo.model;

import java.util.List;

import lombok.Data;

@Data
public class GameLog {

	private Log log;
	private List<Step> steps;
	
}
