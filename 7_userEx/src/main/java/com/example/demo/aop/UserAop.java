package com.example.demo.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserAop {

	@Before("execution(* com.example.demo.controller.TestController.*(..))")
	public void before() {
		System.out.println("程式啟動中...");
	}
	
	@After("execution(* com.example.demo.controller.TestController.*(..))")
	public void after() {
		System.out.println("程式結束...");
	}
}
