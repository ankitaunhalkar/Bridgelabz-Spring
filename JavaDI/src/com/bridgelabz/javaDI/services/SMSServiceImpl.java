package com.bridgelabz.javaDI.services;

public class SMSServiceImpl implements MessageService{

	@Override
	public void sendMessage(String msg, String rec) {
		System.out.println("Email sent to "+rec+ " with Message="+msg);
	}

}
