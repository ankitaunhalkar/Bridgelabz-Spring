package com.bridgelabz.lazyInitialization;

public class Address {
public Address() {
	System.out.println("Address Constructor");
}
String location;
public String getLocation() {
	System.out.println("Mumbai");
	return location;
}
public void setLocation(String location) {
	this.location = location;
}

}
