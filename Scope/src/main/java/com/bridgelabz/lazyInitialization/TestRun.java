package com.bridgelabz.lazyInitialization;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRun {
public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("com/bridgelabz/lazyInitialization/appContext.xml");
	System.out.println("After initialization");
	Address address=(Address)context.getBean("address");
	address.getLocation();
	
}
}
