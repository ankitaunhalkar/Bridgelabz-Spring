package com.bridgelabz.javaDI.consumer;

import com.bridgelabz.javaDI.services.MessageService;

public class MyDIApplication implements Consumer{
	private MessageService service;
	
	public MyDIApplication(MessageService sv) {
		this.service = sv;
	}

	@Override
	public void processMessages(String msg, String rec) {
		this.service.sendMessage(msg, rec);		
	}
}
