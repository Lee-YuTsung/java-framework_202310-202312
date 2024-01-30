package com.example.demo.execute;

import java.util.Arrays;

public class GuessNumber {

	private Integer[] target = new Integer[4];
	private Integer[] guess = new Integer[4];
	private Integer times = 0;
	private Boolean[] outputA = new Boolean[4];
	private Boolean[] outputB = new Boolean[4];
	
	public GuessNumber() {
		super();
		for(int i = 0; i < 4; i++) {
			target[i] = rand();
		}
	}
	
	//data set/get
	public Integer[] getTarget() {
		return target;
	}
	public void setTarget(Integer[] target) {
		this.target = target;
	}
	public Integer[] getGuess() {
		return guess;
	}
	public void setGuess(Integer[] guess) {
		this.guess = guess;
	}
	public Integer getTimes() {
		return times;
	}
	public void setTimes(Integer times) {
		this.times = times;
	}
	public Boolean[] getOutputA() {
		return outputA;
	}
	public void setOutputA(Boolean[] outputA) {
		this.outputA = outputA;
	}
	public Boolean[] getOutputB() {
		return outputB;
	}
	public void setOutputB(Boolean[] outputB) {
		this.outputB = outputB;
	}
	
	//execute
	private int rand() {
		return (int)(Math.random() * 9) + 1;
	}
	private void check() {
		for(int i = 0; i < 4; i++) {
			outputA[i] = !(target[i] == guess[i]);
		}
		if(Arrays.stream(outputA).anyMatch(e -> true)) {
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					if(outputA[i] && outputA[j] && outputB[i]) {
						outputB[i] = !(guess[i] == target[j]);
						continue;
					}
				}
			}
		}
		
	}
	public void reTry() {
		for(int i = 0; i < 4; i++) {
			guess[i] = 0;
			outputA[i] = true;
			outputB[i] = true;
		}
		times += 1;
	}
	public void setGuess(Integer guess) {
		for(int i = 3; i >= 0; i--) {
			this.guess[i] = guess % 10;
			guess = guess / 10;
		}
		check();
	}
	public Integer outputACount() {
		return Arrays.stream(this.outputA).filter(e -> e == false).mapToInt(e -> 1).sum();
	}
	public Integer outputBCount() {
		return Arrays.stream(this.outputB).filter(e -> e == false).mapToInt(e -> 1).sum();
	}
}
