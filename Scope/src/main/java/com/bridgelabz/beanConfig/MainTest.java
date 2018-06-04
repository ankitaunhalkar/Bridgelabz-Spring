package com.bridgelabz.beanConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
public static void main(String[] args) {
	ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
	Employee emp = context.getBean(Employee.class);
	emp.details();
}
}
