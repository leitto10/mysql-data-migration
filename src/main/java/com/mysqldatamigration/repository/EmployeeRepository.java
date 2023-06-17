package com.mysqldatamigration.repository;

import java.util.List;

import com.mysqldatamigration.model.Employees;

public interface EmployeeRepository {
	
	public List<Employees> getAllEmployees();
	public Employees getEmployee(Integer empNo);
	public List<Employees> getAllEmployeesByDateRange(String strDate, String endDate);

}
