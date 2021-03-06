package com.bridgelabz.javaDI.injector;

import com.bridgelabz.javaDI.consumer.Consumer;
import com.bridgelabz.javaDI.consumer.MyDIApplication;
import com.bridgelabz.javaDI.services.SMSServiceImpl;

public class SMSServiceInjector implements MessageServiceInjector{

	@Override
	public Consumer getConsumer() {
		return new MyDIApplication(new SMSServiceImpl());
	}

}
