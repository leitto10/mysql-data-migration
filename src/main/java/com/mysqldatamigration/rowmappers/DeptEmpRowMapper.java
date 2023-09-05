package com.mysqldatamigration.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mysqldatamigration.model.DeptEmp;

public class DeptEmpRowMapper implements RowMapper<DeptEmp>{

	@Override
	public DeptEmp mapRow(ResultSet rs, int rowNum) throws SQLException {
		DeptEmp depEmp = new DeptEmp();
		depEmp.setDeptNo(rs.getString("dept_no"));
		depEmp.setEmpNo(rs.getInt("emp_no"));
		depEmp.setFromDate(rs.getDate("from_date"));
		depEmp.setToDate(rs.getDate("to_date"));
		return depEmp;
	}

}
