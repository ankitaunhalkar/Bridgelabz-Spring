package com.bridgelabz.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeMethod implements MethodBeforeAdvice{

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		
		 System.out.println("===SPRING AOP=== BeforeMethod : Execute before method!");
		
	}

}

