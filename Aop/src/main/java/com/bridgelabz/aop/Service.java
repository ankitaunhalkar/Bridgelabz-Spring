package com.bridgelabz.aop;

public class Service {
	
	private String name;
	
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void printDetails() {
		System.out.println("Name is:"+getName()+" Id is:"+getId());
	}
	
	public void checkName() {
		if(name.length()>10)
		{
			throw new IllegalArgumentException();
		}
	}

	public void sayHello(String message) {
		System.out.println("Hello, "+message);
	}

	@Override
	public String toString() {
		return "Service [name=" + name + ", id=" + id + "]";
	}
	
}
