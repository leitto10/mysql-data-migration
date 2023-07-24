package com.mysqldatamigration.phases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysqldatamigration.model.Employees;
import com.mysqldatamigration.rowmappers.EmployeeToMap;
import com.mysqldatamigration.service.EmployeeService;

@Component
public class Phase1 {
	public static final Log logger = LogFactory.getLog(Phase1.class);
	
	@Autowired
	public EmployeeService employeeService;
	
	public void executeToFile(String startDate, String endDate, String fileName) throws Exception {
		logger.info("Running phase 1...");
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
		Iterator<Employees> iterator = employeeList.iterator();
		int rowNum = 0;

		while(iterator.hasNext()) {
			if(rowNum >= employeeList.size()) {
				break;
			}
			
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			Employees employee = employeeList.get(rowNum);
			employeeToMap.getMapFromEmployee(map, employee);
			ObjectMapper mapper = new ObjectMapper();
			String str = null;
			
			try {
				str = mapper.writeValueAsString(map);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			
			out.print(str+","+"\r\n");
			rowNum++;
		}
		
		bw.flush();
		bw.close();
	}

}
