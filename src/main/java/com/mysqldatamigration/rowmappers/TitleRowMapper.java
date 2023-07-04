package com.mysqldatamigration.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mysqldatamigration.model.Titles;

public class TitleRowMapper implements RowMapper<Titles>{

	@Override
	public Titles mapRow(ResultSet rs, int rowNum) throws SQLException {
		Titles title = new Titles();
		title.setEmpNo(rs.getInt("emp_no"));
		title.setTitle(rs.getString("title"));
		title.setFromDate(rs.getDate("from_date"));
		title.setToDate(rs.getDate("to_date"));
		return title;
	}

}
