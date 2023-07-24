package com.mysqldatamigration.service;

import java.util.List;

import com.mysqldatamigration.model.Departments;

public interface DepartmentService {
	public List<Departments> getDepartments() throws Exception;
	public void addDepartment(Departments deptNo);
	
}
