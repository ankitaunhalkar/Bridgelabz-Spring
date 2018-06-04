package com.bridgelabz.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentProfile {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Profile profile = (Profile) context.getBean("profile");
		
		profile.age();
		
		profile.name();
		
	}

}
