package com.bridgelabz.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee emp = (Employee)context.getBean("emp");
		System.out.println("Name is:"+emp.getName());
		System.out.println("Lname is:"+emp.getLname());
		System.out.println("Age is:"+emp.getAge());
		emp.location();
	}
}
