package com.mysqldatamigration.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mysqldatamigration.model.Employees;
import com.mysqldatamigration.model.Gender;

public class EmployeeRowMapper implements RowMapper<Employees> {

	@Override
	public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employees employee = new Employees();
		employee.setBirthDate(rs.getDate("birth_date"));
		employee.setEmpNo(rs.getInt("emp_no"));
		employee.setFirstName(rs.getString("first_name"));
		employee.setGender(Gender.valueOf(rs.getString("gender")));
		employee.setHireDate(rs.getDate("hire_date"));
		employee.setLastName(rs.getString("last_name"));
		return employee;
	}
	

}
