package com.bridgelabz.ActiveMqDemo;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsProvider {
	 public static ConnectionFactory getConnectionFactory () {
         /*The VM transport allows clients to connect to each other inside
                 the VM without the overhead of the network communication. */
        ConnectionFactory connectionFactory =
                  new ActiveMQConnectionFactory("vm://localhost");

        return connectionFactory;
    }
}
