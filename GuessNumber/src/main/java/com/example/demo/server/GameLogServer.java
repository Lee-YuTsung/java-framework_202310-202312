package com.example.demo.server;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.LogMapper;
import com.example.demo.dao.StepMapper;
import com.example.demo.model.GameLog;
import com.example.demo.model.Log;
import com.example.demo.model.Step;

public class GameLogServer {

	@Autowired
	private LogMapper lm;
	@Autowired
	private StepMapper sm;
	
	//create
	void add(GameLog gl) {
		//log add
		//lm.add(gl.getLog());
		
		//step add
		//Integer gid = 
		//for(Step s : gl.getSteps()) {
			//s.setGid(null);
		//}
	}
	
	//read
	
}
