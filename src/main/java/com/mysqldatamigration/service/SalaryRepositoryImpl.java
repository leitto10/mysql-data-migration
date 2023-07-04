package com.mysqldatamigration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysqldatamigration.model.Salaries;
import com.mysqldatamigration.repository.SalaryRepository;


@Service("salaryService")
public class SalaryRepositoryImpl implements SalaryService {
	
	@Autowired
	private SalaryRepository salaryRepository;

	@Override
	public List<Salaries> getEmployeeSalaries(Integer empNumber) throws Exception {
		List<Salaries> salaries = salaryRepository.getEmployeeSalaries(empNumber);
		
		if(salaries.size() == 0) {
			throw new Exception("No salaries found.");
		}
		
		return salaries;
	}

	@Override
	public void addSalary(Salaries salary) {
		salaryRepository.addSalary(salary);
		
	}

}
