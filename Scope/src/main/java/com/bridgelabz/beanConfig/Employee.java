package com.bridgelabz.beanConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Employee {
	Address address;

	@Bean
	public Address getAddress() {
		return new Address();
	}

	public void setAddress(Address address) {
		this.address = address;
		System.out.println("addrees assigned " + address);
	}

	public void details() {
		System.out.println("Location is:" + address.getAddress());
	}

}
