package com.bridgelabz.dao;

import com.bridgelabz.model.User;

public interface UserDao {
	public void insert(User user); //Insert into databases
	User select(String username, String password);	//view by id	
}
