package com.bridgelabz.dao;

import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bridgelabz.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	EmployeeDaoImpl employeeDao = (EmployeeDaoImpl) context.getBean("employeeDao");
    	
    	//Curd Operations
    	Employee employee = new Employee();
    	
    	int random = new Random().nextInt(1000);
    	employee.setEid(random);
    	employee.setName("Ankita");
    	employee.setCity("Mumbai");
    	
    	//create
    	employeeDao.insert(employee);
    	
    	//read
    	Employee emp = employeeDao.viewById(random);
    	System.out.println("Employee Retrieved :: "+emp);
    	
    	//update
    	employee.setName("Ankita");
    	employee.setCity("Pune");
    	employeeDao.update(employee);
    	
    	//Get All
    	List<Employee> empList = employeeDao.viewAll();
    	System.out.println(empList);
    			
    	//Delete
    	employeeDao.deleteById(random);
    			
    	System.out.println("DONE");
    	
    }
}
