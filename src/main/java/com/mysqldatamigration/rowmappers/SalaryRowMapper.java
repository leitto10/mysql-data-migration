package com.mysqldatamigration.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mysqldatamigration.model.Salaries;

public class SalaryRowMapper implements RowMapper<Salaries>{

	@Override
	public Salaries mapRow(ResultSet rs, int rowNum) throws SQLException {
		Salaries salary = new Salaries();
		salary.setEmp_no(rs.getInt("emp_no"));
		salary.setSalary(rs.getInt("salary"));
		salary.setFromDate(rs.getDate("from_date"));
		salary.setToDate(rs.getDate("to_date"));
		return salary;
	}

}
