package com.bridgelabz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.dao.UserDao;
import com.bridgelabz.model.Login;
import com.bridgelabz.model.User;

@Service
public class UserServicesImpl implements UserServices {

	
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void register(User user) {
		
		if(user != null) {
			userDao.insert(user);
		}
	}

	@Override
	public void login(Login login) {

	}

}
