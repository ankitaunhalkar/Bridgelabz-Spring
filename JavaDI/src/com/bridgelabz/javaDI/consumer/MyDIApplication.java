package com.bridgelabz.javaDI.consumer;

import com.bridgelabz.javaDI.services.MessageService;

public class MyDIApplication implements Consumer{
	private MessageService service;
	
	public MyDIApplication(MessageService sv) {//Constructor Injector
		this.service = sv;
	}
//	public void setService(MessageService service) {//Setter Injector 
//		this.service = service;
//	}
	@Override
	public void processMessages(String msg, String rec) {
		this.service.sendMessage(msg, rec);		
	}
}
