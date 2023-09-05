package com.mysqldatamigration.repository;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mysqldatamigration.model.DeptManager;
import com.mysqldatamigration.rowmappers.DeptManagerRowMapper;

@Repository(value = "deptManagerRepository")
public class DeptManagerRepository {
	public static final Log logger = LogFactory.getLog(DeptEmpRepository.class);
	
	@Autowired
	@Qualifier("firstJdbcTemplate")
	private JdbcTemplate jdbcTemplateOne;
	
	@Autowired
	@Qualifier("secondJdbcTemplate")
	private JdbcTemplate jdbcTemplateTwo;
	
	
	public List<DeptManager> getDepartmentManagers() {
		String query = "SELECT * FROM dept_manager";
		return jdbcTemplateOne.query(query, new DeptManagerRowMapper());
	}
	
	public void addDepartmentManager(DeptManager deptManager) {
		String FOREIGN_KEY_CHECKS_0 = "SET FOREIGN_KEY_CHECKS=0";
		String FOREIGN_KEY_CHECKS_1 = "SET FOREIGN_KEY_CHECKS=1";
		String query = "INSERT INTO dept_manager (emp_no, dept_no, from_date, to_date) VALUES (?, ?, ?, ?)";
		jdbcTemplateTwo.execute(FOREIGN_KEY_CHECKS_0);
		jdbcTemplateTwo.update(query, deptManager.getEmpNo(), deptManager.getDeptNo(), deptManager.getFromDate(), deptManager.getToDate());
		jdbcTemplateTwo.execute(FOREIGN_KEY_CHECKS_1);
	}
	

}
