package com.mysqldatamigration.service;

import java.util.List;

import com.mysqldatamigration.model.Salaries;

public interface SalaryService {
	
	public void addSalary(Salaries salary);
	List<Salaries> getEmployeeSalaries(Integer empNumber) throws Exception;

}
