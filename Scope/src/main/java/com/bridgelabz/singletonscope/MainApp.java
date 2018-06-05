package com.bridgelabz.singletonscope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Service service = (Service) context.getBean("App");
	service.setMessage("Hello wassup?");
		service.getMessage();
		
		Service service1 = (Service) context.getBean("App");
		service1.getMessage();
	}
}
