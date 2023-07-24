package com.mysqldatamigration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysqldatamigration.model.Departments;
import com.mysqldatamigration.repository.DepartmentsRepository;

@Service("departmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentsRepository departmentsRepo;

	@Override
	public List<Departments> getDepartments() throws Exception {
		List<Departments> departments = departmentsRepo.getDepartments();
		
		if(departments.isEmpty()) {
			throw new Exception("No departments fond.");
		}
		
		return departments;
	}

	@Override
	public void addDepartment(Departments deptNo) {
		departmentsRepo.addDepartment(deptNo);
	}
	
	
	
	

}
