package com.bridgelabz.servicesdemo;
public class HelloWorld {
	
	static {
		System.out.println("Hello, Sid!!!");
	}
private String name;
public void setName(String name) {
	this.name = name;
}

public void printHello() {
	System.out.println("Hello ! " + name);
}
}
