package com.bridgelabz.dao;

import com.bridgelabz.model.User;

public interface UserDao {
	public int insert(User user); //Insert into databases
	User select(String username, String password);	//view by id	
	User getByName(String name);
}
