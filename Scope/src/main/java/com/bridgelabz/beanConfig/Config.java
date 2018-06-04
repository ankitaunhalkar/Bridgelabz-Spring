package com.bridgelabz.beanConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public Employee employee()
	{
		Employee employee = new Employee();
		employee.setAddress(address());
		return employee;
		
	}
	
	@Bean
	public Address address()
	{
		return new Address();
	}
}
