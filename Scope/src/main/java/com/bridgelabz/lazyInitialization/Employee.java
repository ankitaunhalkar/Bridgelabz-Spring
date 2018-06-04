package com.bridgelabz.lazyInitialization;

public class Employee {
Address address;
String name;
public Employee() {
	System.out.println("Employee Constructor");
}
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

}
