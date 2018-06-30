package com.bridgelabz.ActiveMqDemo;

import javax.jms.JMSException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JMSException
    {
    	  final Sender sender = new Sender();

          final Receiver receiver = new Receiver();
          receiver.startListener();

          for (int i = 1; i <= 5; i++) {
              String m = "Hello world! " + i;
              sender.sendMessage(m);
              try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          }

          sender.destroy();
          receiver.destroy();    
     }
}
