package com.bridgelabz.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bridgelaz.model.Employee;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	Map<Integer, Employee> empdata = new HashMap<Integer, Employee>();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "home";
	}
	
	
	@RequestMapping(value ="/set", method = RequestMethod.GET)
	public @ResponseBody Employee setEmployee() {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Ankita");
		emp.setCity("Mumbai");
		empdata.put(1, emp);
		return emp;
	}
	
	@RequestMapping(value ="/getid/{id}", method = RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("id") int empid) {
		
		logger.info("fetching emp by id:"+empid);
		return empdata.get(empid);
	}
	
	@PostMapping(value = "/add")
	@ResponseBody
	public Employee addEmployee(@RequestBody Employee emp) {

		logger.info("adding:"+emp);
		empdata.put(emp.getId(), emp);
		return emp;
	}
	
	@GetMapping(value = "/displayall")
	@ResponseBody
	public List<Employee> listEmployee(){

		logger.info("fetching");
		List<Employee> emp = new ArrayList<Employee>();
		Set<Integer> setemp = empdata.keySet();
		for (Integer integer : setemp) {
			emp.add(empdata.get(integer));
		}
		return emp;
	}
	
	@PutMapping(value = "/delete/{id}")
	@ResponseBody
	public Employee deleteEmpoyee(@PathVariable("id") int empid) {

		logger.info("deleting emp by id:"+empid);
		Employee emp = empdata.get(empid);
		empdata.remove(empid);
		return emp;
		
	}
}
