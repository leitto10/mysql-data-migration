package com.mysqldatamigration.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysqldatamigration.model.DeptEmp;
import com.mysqldatamigration.repository.DeptEmpRepository;

@Service("deptEmpServiceImpl")
public class DeptEmpServiceImpl implements DeptEmpService {
	public static final Log logger = LogFactory.getLog(DeptEmpServiceImpl.class);
		
	@Autowired
	private DeptEmpRepository deptEmpRepo;
	

	@Override
	public void addDeptEmp(DeptEmp deptEmp) {
		deptEmpRepo.addDeptEmp(deptEmp);	
	}

	@Override
	public List<DeptEmp> getAllDeptEmp() throws Exception {
		List<DeptEmp> getAll = deptEmpRepo.getAllDeptEmp();
		
		if(getAll.isEmpty()) {
			throw new Exception("Data not found.");
		}
		
		return getAll;
	}

}
