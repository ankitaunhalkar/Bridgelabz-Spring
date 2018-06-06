package com.bridgelabz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bridgelabz.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	DataSource datasource;

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

	@Override
	public void insert(Employee employee) {

		String query = "insert into employee values(?,?,?)";

		JdbcTemplate jdbctemplate = new JdbcTemplate(datasource);
		
		Object[] object = new Object[] { employee.getEid(), employee.getName(), employee.getCity() };
		
		int out = jdbctemplate.update(query, object);
		
		if (out != 0) {
			System.out.println("Employee saved with id=" + employee.getEid());
		} else {
			System.out.println("Employee save failed with id=" + employee.getEid());
		}
	}

	@Override
	public void update(Employee employee) {
		
		String query = "update employee set name = ?, city = ? where id = ?";
		
		JdbcTemplate jdbctemplate = new JdbcTemplate(datasource);
		
		Object[] object = new Object[] {
			employee.getName(),
			employee.getCity(),
			employee.getEid()
		};
		
		int out = jdbctemplate.update(query,object);
		if (out != 0) {
			System.out.println("Employee updated with id=" + employee.getEid());
		} else {
			System.out.println("Employee update failed with id=" + employee.getEid());
		}

	}

	@Override
	public void deleteById(int id) {
		
		String query = "delete from employee where id = ?";
		
		JdbcTemplate jdbctemplate = new JdbcTemplate(datasource);
		
		int out = jdbctemplate.update(query,id);
		
		if(out != 0) {
			System.out.println("Employee deleted with id=" + id);
		} else {
			System.out.println("Employee failed to delete with id=" + id);
		}

	}

	@Override
	public Employee viewById(int id) {
		
		String query = "select * from employee where id = ?";
		
		JdbcTemplate jdbctemplate = new JdbcTemplate(datasource);
		
		
		//using RowMapper anonymous class, we can create a separate RowMapper for reuse
				Employee emp = jdbctemplate.queryForObject(query, new Object[]{id}, new RowMapper<Employee>(){

					@Override
					public Employee mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Employee emp = new Employee();
						emp.setEid(rs.getInt("id"));
						emp.setName(rs.getString("name"));
						emp.setCity(rs.getString("city"));
						return emp;
					}});
				
				return emp;

	}

	@Override
	public List<Employee> viewAll() {

		String query = "select id, name, city from employee";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
		List<Employee> empList = new ArrayList<Employee>();

		List<Map<String,Object>> empRows = jdbcTemplate.queryForList(query);
		
		for(Map<String,Object> empRow : empRows){
			Employee emp = new Employee();
			emp.setEid(Integer.parseInt(String.valueOf(empRow.get("id"))));
			emp.setName(String.valueOf(empRow.get("name")));
			emp.setCity(String.valueOf(empRow.get("city")));
			empList.add(emp);
		}
		return empList;
	}

}
