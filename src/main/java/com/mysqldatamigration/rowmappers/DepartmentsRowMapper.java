package com.mysqldatamigration.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mysqldatamigration.model.Departments;

public class DepartmentsRowMapper implements RowMapper<Departments>{

	@Override
	public Departments mapRow(ResultSet rs, int rowNum) throws SQLException {
		Departments department = new Departments();
		department.setDeptNo(rs.getString("dept_no"));
		department.setDeptName(rs.getString("dept_name"));
		return department;
	}

}
