package com.bridgelabz.employee;

public class Employee {

	Address address;
	String name;

	/*public Employee(Address address) {
		this.address = address;
	}*/
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void details()
	{
		System.out.println("Name: Ankita, Location:"+address.getLocation());
		System.out.println("Name is :"+name);
	}
	
	
}
