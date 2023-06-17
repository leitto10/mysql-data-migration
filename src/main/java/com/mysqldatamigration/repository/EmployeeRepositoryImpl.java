package com.mysqldatamigration.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mysqldatamigration.model.Employees;
import com.mysqldatamigration.rowmappers.EmployeeRowMapper;


@Repository(value = "employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<Employees> getAllEmployees() {
		String query = "SELECT * FROM employees";
		return jdbcTemplate.query(query, new EmployeeRowMapper());
	}

	@Override
	public List<Employees> getAllEmployeesByDateRange(String startDate, String endDate) {		
		String sDate = startDate + " 00:00:00";
		String eDate = endDate + " 23:59:59";
		String query = "SELECT * FROM employees WHERE hire_date BETWEEN ? AND ?";
		
		try {
			return	jdbcTemplate.query(query, new EmployeeRowMapper(), new Object[] { sDate,  eDate});
		} catch (Exception e) {
			return null;
		}
		
	}

}
