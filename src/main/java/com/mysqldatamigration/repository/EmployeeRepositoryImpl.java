package com.mysqldatamigration.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mysqldatamigration.model.Employees;


@Repository(value = "employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<Employees> getAllEmployees() {
		String query = "SELECT * FROM employees";
		return jdbcTemplate.query(query, new EmployeesRowMapper());
	}
	
	public Employees getEmployee(Integer empNo) {
		String query = "SELECT * FROM employees WHERE emp_no = ?";
		
		try {
			return jdbcTemplate.queryForObject(query, new EmployeesRowMapper(), new Object[] { empNo });

		} catch (Exception e) {
			return null;
		}
	}
	

	@Override
	public List<Employees> getAllEmployeesByDateRange(String startDate, String endDate) {
		List<Employees> employees = new ArrayList<>();
		
		String sDate = startDate + " 00:00:00";
		String eDate = endDate + " 23:59:59";
		String query = "SELECT * FROM employees WHERE hire_date BETWEEN ? AND ?";
		
		try {
			return jdbcTemplate.query(query, new EmployeesRowMapper(), new Object[] { sDate,  eDate});
			
		} catch (Exception e) {
			return null;
		}
		
	}

}
