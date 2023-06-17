package com.mysqldatamigration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysqldatamigration.model.Employees;
import com.mysqldatamigration.repository.EmployeeRepository;


@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employees> getEmployees() throws Exception {
		List<Employees> employees = employeeRepository.getAllEmployees();
		
		if(employees.size() == 0) {
			throw new Exception("Employees not found.");
		}
		
		return employees;
	}

	@Override
	public List<Employees> getAllEmployeesByDateRange(String strDate, String endDate) throws Exception {
		List<Employees> employees = employeeRepository.getAllEmployeesByDateRange(strDate, endDate);
		
		if(employees.size() == 0) {
			throw new Exception("Employees not found.");
		}
		
		return employees;
	}

	@Override
	public Employees getEmployee(Integer empNo) throws Exception {
		Employees employee = employeeRepository.getEmployee(empNo);
		
		if(employee == null) {
			throw new Exception("No employee found.");
		}
		
		return employee;
	}

}
