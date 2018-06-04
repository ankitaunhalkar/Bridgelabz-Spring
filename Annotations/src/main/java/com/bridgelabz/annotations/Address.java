package com.bridgelabz.annotations;

public class Address {
String location;
String street;
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}

public void address() {
System.out.println(street+","+location);
}

}
