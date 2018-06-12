package com.bridgelabz.service;

import com.bridgelabz.model.Login;
import com.bridgelabz.model.User;

public interface UserServices {
	
	int register(User user);
	User login(Login login);
	User getByEmail(String name);
	
}
