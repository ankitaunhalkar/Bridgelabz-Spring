package com.bridgelabz.consumer;

import com.bridgelabz.services.MessageService;

public class MyXMLApplication {
	private MessageService service;
//Constructor based dependency injection
//	public MyXMLApplication(MessageService sv) {
//		this.service = sv;
//	}

	//Setter based dependency injection
	public void setService(MessageService service) {
		this.service = service;
	}
	
	public boolean processMessage(String msg, String rec) {
		return this.service.sendMessage(msg, rec);
	}
}
