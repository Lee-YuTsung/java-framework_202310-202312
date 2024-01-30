package com.example.demo.util;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAop {

	@Before("execution(* com.example.demo.controller.BeanController.*(..))")
	public void before() {
		System.out.println("i am before");
	}
	
	@After("execution(* com.example.demo.controller.BeanController.*(..))")
	public void after() {
		System.out.println("i am after");
	}
}
