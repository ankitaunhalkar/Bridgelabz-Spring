package com.bridgelabz.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bridgelabz.consumer.MyXMLApplication;

public class ClientApplication {
	public static void main(String[] args) {
//	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//			"applicationContext.xml");
//	MyXMLApplication app = context.getBean(MyXMLApplication.class);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MyXMLApplication app = (MyXMLApplication) context.getBean("MyXMLApp");
		app.processMessage("Hi Pankaj", "pankaj@abc.com");


	}
}
