package com.bridgelabz.javaDI.injector;

import com.bridgelabz.javaDI.consumer.Consumer;
import com.bridgelabz.javaDI.consumer.MyDIApplication;
import com.bridgelabz.javaDI.services.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector{

	@Override
	public Consumer getConsumer() {
		return new MyDIApplication(new EmailServiceImpl());
	}

}
