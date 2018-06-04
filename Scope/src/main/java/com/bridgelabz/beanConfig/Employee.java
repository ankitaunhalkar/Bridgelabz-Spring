package com.bridgelabz.beanConfig;


public class Employee {
	Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	
	}

	public void details() {
		System.out.println("Location is:" + address.getAddress());
	}

}
