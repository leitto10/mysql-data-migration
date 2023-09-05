package com.mysqldatamigration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysqldatamigration.model.DeptManager;
import com.mysqldatamigration.repository.DeptManagerRepository;

@Service("deptManagerServiceImpl")
public class DeptManagerServiceImpl implements DeptManagerService {

	@Autowired
	private DeptManagerRepository dptManagerRepo;
	
	@Override
	public List<DeptManager> departmentManagers() throws Exception {
		List<DeptManager> depManagerList = dptManagerRepo.getDepartmentManagers();
		
		if(depManagerList.isEmpty()) {
			throw new Exception("Department manager not found.");
		}
		
		return depManagerList;
	}

	@Override
	public void addDeptManager(DeptManager deptManager) {
		dptManagerRepo.addDepartmentManager(deptManager);
	}

}
