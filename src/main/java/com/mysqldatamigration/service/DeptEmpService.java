package com.mysqldatamigration.service;

import java.util.List;

import com.mysqldatamigration.model.DeptEmp;

public interface DeptEmpService {	
	public List<DeptEmp> getAllDeptEmp() throws Exception;
	public void addDeptEmp(DeptEmp deptEmp);

}
