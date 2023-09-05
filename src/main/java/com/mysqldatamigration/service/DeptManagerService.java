package com.mysqldatamigration.service;

import java.util.List;

import com.mysqldatamigration.model.DeptManager;

public interface DeptManagerService {
	public List<DeptManager> departmentManagers() throws Exception;
	public void addDeptManager(DeptManager deptManager);

}
