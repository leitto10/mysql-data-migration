package com.mysqldatamigration.repository;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mysqldatamigration.model.Salaries;
import com.mysqldatamigration.rowmappers.SalaryRowMapper;


@Repository(value = "salaryRepository")
public class SalaryRepository {
	public static final Log logger = LogFactory.getLog(SalaryRepository.class);
	
	@Autowired
	@Qualifier("firstJdbcTemplate")
	private JdbcTemplate jdbcTemplateOne;


	public List<Salaries> getEmployeeSalaries(Integer employeeNumber) {
		String query = "SELECT * FROM salaries WHERE emp_no = ?";
		
		try {
			return jdbcTemplateOne.query(query, new SalaryRowMapper(), new Object[] {employeeNumber});
		} catch (Exception e) {
			return null;
		}
		
	}
}
