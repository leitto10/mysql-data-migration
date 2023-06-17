package com.mysqldatamigration.service;

import java.util.List;

import com.mysqldatamigration.model.Employees;

public interface EmployeeService {
	
	public List<Employees> getEmployees() throws Exception;
	public Employees getEmployee(Integer empNo) throws Exception;
	public List<Employees> getAllEmployeesByDateRange(String strDate, String endDate) throws Exception;

}
