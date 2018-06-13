package com.bridgelabz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.dao.UserDao;
import com.bridgelabz.model.Login;
import com.bridgelabz.model.User;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserDao userDao;

	@Override
	public int register(User user) {
		int status = 0;
		
		if(user!=null) {
			User usercheck = userDao.getByEmail(user.getEmail());
			if(usercheck==null) {
				status = userDao.insert(user);
			}else {
				status = 0;
			}
		}
		/*try {
			if (user != null) {
				User usercheck = userDao.getByEmail(user.getEmail());
			}
		} catch (Exception e) {
			System.out.println("No user found");
				status = userDao.insert(user);
		}*/
		return status;
	}

	@Override
	public User login(Login login) {
		/*User user = null;
		try {
			if (login != null) {
				// User user = getUserBylogin.EmailId();
				// user.getpassword()==
				user = userDao.select(login.getEmail(), login.getPassword());
			}
		} catch (Exception e) {
			System.out.println("No user found");
		}
		return user;*/
		User loginCheck = null;
		if (login != null) {
			loginCheck = userDao.getByEmail(login.getEmail());
			if((loginCheck!= null) && (loginCheck.getPassword().equals(login.getPassword())))
			{
				return loginCheck;
			}
		}
		return loginCheck;
	}

	@Override
	public User getByEmail(String email) {
		return userDao.getByEmail(email);
	}

}
