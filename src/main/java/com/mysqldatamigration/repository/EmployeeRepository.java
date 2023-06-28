package com.mysqldatamigration.repository;

import java.util.List;

import com.mysqldatamigration.model.Employees;

public interface EmployeeRepository {
	
	public void uploadEmployeeData(Employees employee);
	public List<Employees> getAllEmployees();
	public List<Employees> getAllEmployeesByDateRange(String strDate, String endDate);

}
