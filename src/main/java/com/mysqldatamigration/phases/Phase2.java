package com.mysqldatamigration.phases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.stereotype.Component;

import com.mysqldatamigration.model.Employees;
import com.mysqldatamigration.rowmappers.EmployeeToTable;
import com.mysqldatamigration.service.EmployeeService;

@Component
public class Phase2 {
	public static final Log logger = LogFactory.getLog(Phase2.class);
	
	@Autowired
	public EmployeeService employeeService;
	
	public void executeToTable() throws Exception {
		System.out.println("\n");
		String currDirectory = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
		
		logger.info("currDirectory: "+currDirectory);
		System.out.println("\n");
		
		File file = new File(currDirectory, "file.json");
		JSONArray jsonArray = null;
		
		if(file.exists()) {
			logger.info("File: "+file);
			
			try {
				InputStream input = new FileInputStream(file);
				String jsonTxt = IOUtils.toString(input, "UTF-8");
                jsonTxt = "[" + jsonTxt + "]";
                jsonArray = new JSONArray(jsonTxt);
                logger.info("jsonTxt: "+jsonTxt);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
		this.uploadData(jsonArray);
	}
	
	public void uploadData(JSONArray jsonArray) throws Exception {
		EmployeeToTable mapper = new EmployeeToTable();
		
		List<Employees> employeeList = mapper.jsonArrayToList(jsonArray);
		logger.info("employeeList: "+employeeList.size());
		
		for(int i = 0; i < employeeList.size(); i++) {
			Employees employee = employeeList.get(i);
			employeeService.uploadEmployeeData(employee);
		}
		
		logger.info("Data Uploaded Successfully");
	}
	

}
