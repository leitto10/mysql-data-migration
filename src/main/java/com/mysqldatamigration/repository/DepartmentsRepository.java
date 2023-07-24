package com.mysqldatamigration.repository;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mysqldatamigration.model.Departments;
import com.mysqldatamigration.rowmappers.DepartmentsRowMapper;

@Repository("departmentsRepository")
public class DepartmentsRepository {
	public static final Log logger = LogFactory.getLog(DepartmentsRepository.class);
	
	@Autowired
	@Qualifier("firstJdbcTemplate")
	private JdbcTemplate jdbcTemplateOne;
	
	@Autowired
	@Qualifier("secondJdbcTemplate")
	private JdbcTemplate jdbcTemplateTwo;
	
	public List<Departments> getDepartments() {
		String query = "SELECT * FROM departments";
		return jdbcTemplateOne.query(query, new DepartmentsRowMapper());
	}
	
	public void addDepartment(Departments department) {
		String query = "INSERT INTO departments (dept_no, dept_name) VALUES (?, ?)";
		jdbcTemplateTwo.update(query, department.getDeptNo(), department.getDeptName());
	}

}
