package com.mysqldatamigration.repository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mysqldatamigration.model.Titles;
import com.mysqldatamigration.rowmappers.TitleRowMapper;


@Repository(value = "titleRepository")
public class TitleRepository {
public static final Log logger = LogFactory.getLog(TitleRepository.class);
	
	@Autowired
	@Qualifier("firstJdbcTemplate")
	private JdbcTemplate jdbcTemplateOne;
	
	@Autowired
	@Qualifier("secondJdbcTemplate")
	private JdbcTemplate jdbcTemplateTwo;
	
	
	public Titles getTitle(Integer empNumber) {
		String query = "SELECT * FROM titles WHERE emp_no = ?";
		
		try {
			return jdbcTemplateOne.queryForObject(query, new TitleRowMapper(), new Object[] {empNumber});
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public void addTitle(Titles title) {
		String query = "INSERT INTO titles (emp_no, title, from_date, to_date)"
				+ "VALUES (?, ?, ?, ?)";
		jdbcTemplateTwo.update(query, title.getEmpNo(), title.getTitle(), title.getFromDate(), title.getToDate());
	}

}
