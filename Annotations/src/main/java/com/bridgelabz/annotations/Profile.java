package com.bridgelabz.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Profile {
	
	@Autowired
/*	@Qualifier("student2")*/
	private Student student;
	
	public void age() {
		System.out.println("Age is "+student.getAge());
		
	}
	
	public void name() {
		System.out.println("Name is "+student.getName());

	}
	
}

