package com.mysqldatamigration.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mysqldatamigration.model.DeptManager;

public class DeptManagerRowMapper implements RowMapper<DeptManager>{

	@Override
	public DeptManager mapRow(ResultSet rs, int rowNum) throws SQLException {
		DeptManager deptManager = new DeptManager();
		deptManager.setEmpNo(rs.getInt("emp_no"));
		deptManager.setDeptNo(rs.getString("dept_no"));
		deptManager.setFromDate(rs.getDate("from_date"));
		deptManager.setToDate(rs.getDate("to_date"));
		return deptManager;
	}

}
