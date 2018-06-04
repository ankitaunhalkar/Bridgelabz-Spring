package com.bridgelabz.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class Employee {
	private String name;
	private String lname;
	private Integer age;
	// private Address address;
	
	@Autowired(required=false)
	private Address address;
	
	
	/*@Autowired(required=false)
	public Employee(Address address) {
		this.address = address;
	}*/
	
	public Integer getAge() {
		return age;
	}

/*	@Autowired(required=false)
	public void setAge(Integer age) {
		this.age = age;
	}
*/
	public Address getAddress() {
		return address;
	}
	
/*	@Autowired
	public void setAddress(Address address) {
		this.address = address;
	}
*/
	public String getName() {
		return name;
	}

	public void location()
	{
		address.address();
	}
	@Required
	public void setName(String name) {
		this.name = name;
	}

	public String getLname() {
		return lname;
	}

	@Required
	public void setLname(String lname) {
		this.lname = lname;
	}

}
