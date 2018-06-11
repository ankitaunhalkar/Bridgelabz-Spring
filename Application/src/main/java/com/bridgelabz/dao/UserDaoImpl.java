package com.bridgelabz.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bridgelabz.model.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void insert(User user) {
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		System.out.println(user.getCity());
		System.out.println("dao");
		String query = "insert into users(name,password,email,city) values(?,?,?,?)";
		Object[] object = new Object[] { user.getName(), user.getPassword(), user.getEmail(), user.getCity() };

		int out = jdbcTemplate.update(query, object);

		if (out != 0) {

			System.out.println("Employee saved with name=" + user.getName());

		} else {

			System.out.println("Employee save failed with id=" + user.getName());

		}

	}

	@Override
	public User select(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
