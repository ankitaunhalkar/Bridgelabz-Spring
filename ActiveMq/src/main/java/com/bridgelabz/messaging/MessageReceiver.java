package com.bridgelabz.messaging;

import javax.jms.JMSException;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
	 
	    private static final String ORDER_QUEUE = "order-queue"; 
	     
	    @JmsListener(destination = ORDER_QUEUE)
	    public void receiveMessage(String msg) throws JMSException {
	       System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	      
	    
	        System.out.println("Application : headers received : {}"+msg);
	      
	    }
}
