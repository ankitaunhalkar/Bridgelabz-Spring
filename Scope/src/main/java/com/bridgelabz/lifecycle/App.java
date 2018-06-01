package com.bridgelabz.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	LifeCycle app = (LifeCycle) context.getBean("Lifecycle");
	app.setMessage("Hello Bean");
	app.getMessage();
	((AbstractApplicationContext) context).registerShutdownHook();
}
}
