package com.bridgelabz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bridgelabz.model.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int insert(User user) {

		String query = "insert into users(name,password,email,city) values(?,?,?,?)";
		Object[] object = new Object[] { user.getName(), user.getPassword(), user.getEmail(), user.getCity() };

		int out = jdbcTemplate.update(query, object);

		if (out != 0) {

			System.out.println("Employee saved with name=" + user.getName());

		} else {

			System.out.println("Employee save failed with id=" + user.getName());

		}

		return out;

	}

	@Override
	public User select(String email, String password) {

		String query = "select * from users where email=? and password=?";

		User user = jdbcTemplate.queryForObject(query, new Object[] { email, password }, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setEmail(rs.getString("email"));
				return user;
			}
		});

		return user;

	}

	@Override
	public User getByEmail(String email) {
		String query = "select * from users where email=?";
		 List<User> list = jdbcTemplate.query(query, new Object[] { email }, new RowMapper<User>()  {
/*		User user = jdbcTemplate.queryForObject(query, new Object[] { email }, new RowMapper<User>() {
*/
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setCity(rs.getString("city"));
				return user;
			}
		});
		 System.out.println(list.size());
		// return (User) list;
		 return list.size() > 0 ? list.get(0) : null;
	}

}
