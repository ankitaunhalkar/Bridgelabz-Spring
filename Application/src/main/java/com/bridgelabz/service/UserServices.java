package com.bridgelabz.service;

import com.bridgelabz.model.Login;
import com.bridgelabz.model.User;

public interface UserServices {
	
	void register(User user);
	void login(Login login);
	
}
