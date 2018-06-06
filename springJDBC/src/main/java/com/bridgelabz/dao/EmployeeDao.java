package com.bridgelabz.dao;

import java.util.List;

import com.bridgelabz.model.Employee;

public interface EmployeeDao {
void insert(Employee employee); //Insert into databases
void update(Employee employee); //Update into database
void deleteById(int id); //delete by id
Employee viewById(int id);	//view by id
List<Employee> viewAll();	//view all
}
