package com.bridgelabz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.dao.UserDao;
import com.bridgelabz.model.Login;
import com.bridgelabz.model.User;

@Service
public class UserServicesImpl implements UserServices {
	
	private UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int register(User user) {
		int status = 0;
		if(user != null) {
			status = userDao.insert(user);
		}
		return status;
	}

	@Override
	public User login(Login login) {
		User user = null;
		try {
			if(login != null)
			{
				user = userDao.select(login.getEmail(), login.getPassword());
			}
		} catch (Exception e) {
			System.out.println("No user found");
		}
		return user;
	}

	@Override
	public User getByName(String name) {
		return userDao.getByName(name);
	}

}
