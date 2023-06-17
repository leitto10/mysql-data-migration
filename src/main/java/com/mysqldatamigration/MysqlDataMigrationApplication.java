package com.mysqldatamigration;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mysqldatamigration.model.Employees;
import com.mysqldatamigration.service.EmployeeService;

@SpringBootApplication
public class MysqlDataMigrationApplication implements CommandLineRunner {
	public static final Log logger = LogFactory.getLog(MysqlDataMigrationApplication.class);
	
	@Autowired
	public EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(MysqlDataMigrationApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		//getAllEmployees();
		//getEmployee();
		getAllEmployeesByDateRange("2000-01-01", "2000-01-30");
	}
	
	public void getEmployee() {
		try {
			logger.info("Getting employee info...");
			Employees employee = employeeService.getEmployee(10001);
			
			
			logger.info(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getAllEmployees() {
		try {
			logger.info("Getting the data...");
			
			List<Employees> employeeList = employeeService.getEmployees();
			
			for(Employees employee: employeeList) {
				logger.info(employee);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getAllEmployeesByDateRange(String startDate, String endDate) {
		try {
			logger.info("Quering the data...");
			List<Employees> employeeList = employeeService.getAllEmployeesByDateRange(startDate, endDate);
			
			for(Employees employee: employeeList) {
				logger.info(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
