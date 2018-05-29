package com.bridgelabz.javaDI.test;

import com.bridgelabz.javaDI.consumer.Consumer;
import com.bridgelabz.javaDI.injector.EmailServiceInjector;
import com.bridgelabz.javaDI.injector.MessageServiceInjector;
import com.bridgelabz.javaDI.injector.SMSServiceInjector;

public class MyMessageDITest {
	public static void main(String[] args) {
		String email = "a@gmail.com";
		String msg = "Hello to DI world";
		String phone = "9874563210";
		MessageServiceInjector injector = null;
		Consumer app = null;
		
		//Send email
		injector = new EmailServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, email);
		
		//Send message
		injector = new SMSServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, phone);
	}
}
