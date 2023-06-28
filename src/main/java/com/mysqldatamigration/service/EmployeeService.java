package com.mysqldatamigration.service;

import java.util.List;

import com.mysqldatamigration.model.Employees;

public interface EmployeeService {
	
	public void uploadEmployeeData(Employees employee) throws Exception;
	public List<Employees> getEmployees() throws Exception;
	public List<Employees> getAllEmployeesByDateRange(String strDate, String endDate) throws Exception;

}
