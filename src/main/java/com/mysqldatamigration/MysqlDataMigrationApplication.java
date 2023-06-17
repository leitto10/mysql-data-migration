package com.mysqldatamigration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysqldatamigration.model.Employees;
import com.mysqldatamigration.rowmappers.EmployeeToMap;
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
		//getAllEmployeesByDateRange("2000-01-01", "2000-01-30");
		this.executeToFile("2000-01-01", "2000-01-30", "file.json");
	}
	
	public void executeToFile(String startDate, String endDate, String fileName) throws Exception {
		EmployeeToMap employeeToMap = new EmployeeToMap();
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter out = null;
		
		try {
			fw = new FileWriter(fileName, true);
			bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		List<Employees> employeeList = employeeService.getAllEmployeesByDateRange(startDate, endDate);
		logger.info("Number of records returned: " + employeeList.size());
		
		
		for(int i = 0; i < employeeList.size(); i++) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			Employees employee = employeeList.get(i);
			logger.info(employee);
			
			employeeToMap.getMapFromEmployee(map, employee);
			ObjectMapper mapper = new ObjectMapper();
			String str = null;
			
			try {
				str = mapper.writeValueAsString(map);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			
			out.print(str+","+"\r\n");
		}
		
		bw.flush();
		bw.close();	
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
