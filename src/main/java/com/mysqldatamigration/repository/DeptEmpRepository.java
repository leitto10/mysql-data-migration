package com.mysqldatamigration.repository;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mysqldatamigration.model.DeptEmp;
import com.mysqldatamigration.rowmappers.DeptEmpRowMapper;

@Repository(value = "deptEmpRepository")
public class DeptEmpRepository {
	public static final Log logger = LogFactory.getLog(DeptEmpRepository.class);
	
	@Autowired
	@Qualifier("firstJdbcTemplate")
	private JdbcTemplate jdbcTemplateOne;
	
	@Autowired
	@Qualifier("secondJdbcTemplate")
	private JdbcTemplate jdbcTemplateTwo;
	
	
	public List<DeptEmp> getAllDeptEmp() {
		String query = "SELECT * FROM dept_emp";
		return jdbcTemplateOne.query(query, new DeptEmpRowMapper());
	}
	
	
	public void addDeptEmp(DeptEmp deptEmp) {
		String FOREIGN_KEY_CHECKS_0 = "SET FOREIGN_KEY_CHECKS=0";
		String FOREIGN_KEY_CHECKS_1 = "SET FOREIGN_KEY_CHECKS=1";
		String query = "INSERT INTO dept_emp (emp_no, dept_no, from_date, to_date) VALUES (?, ?, ?, ?)";
		jdbcTemplateTwo.execute(FOREIGN_KEY_CHECKS_0);
		jdbcTemplateTwo.update(query, deptEmp.getEmpNo(), deptEmp.getDeptNo(), deptEmp.getFromDate(), deptEmp.getToDate());
		jdbcTemplateTwo.execute(FOREIGN_KEY_CHECKS_1);
	}

}
