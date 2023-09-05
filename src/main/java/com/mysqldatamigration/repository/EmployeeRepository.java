package com.mysqldatamigration.repository;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mysqldatamigration.model.Employees;
import com.mysqldatamigration.rowmappers.EmployeeRowMapper;

@Repository(value = "employeeRepository")
public class EmployeeRepository {
	public static final Log logger = LogFactory.getLog(EmployeeRepository.class);
	
	@Autowired
	@Qualifier("firstJdbcTemplate")
	private JdbcTemplate jdbcTemplateOne;
	
	@Autowired
	@Qualifier("secondJdbcTemplate")
	private JdbcTemplate jdbcTemplateTwo;
	

	public List<Employees> getAllEmployees() {
		String query = "SELECT * FROM employees LIMIT 10";
		return jdbcTemplateOne.query(query, new EmployeeRowMapper());
	}

	public List<Employees> getAllEmployeesByDateRange(String startDate, String endDate) {
		String query = "SELECT * FROM employees WHERE hire_date BETWEEN ? AND ?";
		String sDate = startDate + " 00:00:00";
		String eDate = endDate + " 23:59:59";
		
		try {
			return	jdbcTemplateOne.query(query, new EmployeeRowMapper(), new Object[] { sDate,  eDate});
		} catch (Exception e) {
			return null;
		}
	}

	public void uploadEmployeeData(Employees employee) {
		String query = "INSERT INTO employees (emp_no, birth_date, first_name, last_name, gender, hire_date)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplateTwo.update(query, employee.getEmpNo(), 
										employee.getBirthDate(), 
										employee.getFirstName(),
										employee.getLastName(),
										employee.getGender().toString(),
										employee.getHireDate());
	}
}
