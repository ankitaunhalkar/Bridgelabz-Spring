package com.bridgelabz.aop;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       Service service = (Service) context.getBean("sampleServiceProxy");
       try {
       service.checkName();
       }catch(Exception e) {
    	   System.out.println("SampleService: Method checkName() thrown exception");
       }
       service.sayHello("Sky is blue");
     
    }
}
