package com.mysqldatamigration.phases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Component;

import com.mysqldatamigration.model.Departments;
import com.mysqldatamigration.model.DeptEmp;
import com.mysqldatamigration.model.DeptManager;
import com.mysqldatamigration.model.Employees;
import com.mysqldatamigration.rowmappers.EmployeeListToTable;
import com.mysqldatamigration.service.DepartmentService;
import com.mysqldatamigration.service.DeptEmpService;
import com.mysqldatamigration.service.DeptManagerService;
import com.mysqldatamigration.service.EmployeeService;


@Component
public class PhaseTwo {
	public static final Log logger = LogFactory.getLog(PhaseTwo.class);
	
	@Autowired
	public EmployeeService employeeService;
	
	@Autowired
	public DepartmentService departmentService;
	
	@Autowired
	public DeptManagerService deptManagerService;
	
	@Autowired
	public DeptEmpService deptEmployeeService;
	
	
	public void executeToTable(String fileName) throws FileNotFoundException, JSONException {
		logger.info("Running phase 2 ...");
		String currDirectory = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
		
		logger.info("currDirectory: "+currDirectory);
		System.out.println("\n");
		
		File file = new File(currDirectory, fileName);
		JSONArray jsonArray = null;
		
		if(file.exists()) {
			logger.info("File: " + file);
			
			try {
				InputStream input = new FileInputStream(file);
				String jsonTxt = IOUtils.toString(input, "UTF-8");
                jsonTxt = "[" + jsonTxt + "]";
                jsonArray = new JSONArray(jsonTxt);
			} catch (FileNotFoundException e) {
				System.out.println("File Not Found");
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			logger.info("The file doesn't exits...");
		}
		
		this.uploadData(jsonArray);
	}
	
	public void uploadData(JSONArray jsonArray) throws JSONException {
		EmployeeListToTable mapper = new EmployeeListToTable();
		
		try {
			logger.info("Uploading employees data...");
			List<Employees> employeeList = mapper.jsonArrayToList(jsonArray);
			logger.info("employeeList: "+employeeList.size());		

			for(Employees employee: employeeList) {
					employeeService.uploadEmployeeData(employee);
			}
			
			logger.info("Employee data uploaded Successfully");
		} catch (Exception e) {
			logger.info(e);
		}
		
//		try {
//			logger.info("Uploading departmens data...");
//			List<Departments> getAllDepartments = departmentService.getDepartments();
//			
//			for(Departments department: getAllDepartments) {
//				departmentService.addDepartment(department);
//			}
//			
//			logger.info("Departments data uploaded Successfully");
//		} catch (Exception e) {
//			logger.info(e);
//		}
//		
//		try {
//			logger.info("Uploading department manager data...");
//			List<DeptManager> getDepartmentManager = deptManagerService.departmentManagers();
//			
//			for(DeptManager dptManager: getDepartmentManager) {
//				deptManagerService.addDeptManager(dptManager);
//			}
//			
//			logger.info("Departments manager data uploaded Successfully");
//		} catch (Exception e) {
//			logger.info(e);
//		}
//		
//		try {
//			logger.info("Uploading department employee data...");
//			List<DeptEmp> getDptEmployee = deptEmployeeService.getAllDeptEmp();
//			
//			for(DeptEmp deptEmp: getDptEmployee) {
//				deptEmployeeService.addDeptEmp(deptEmp);
//			}
//			
//			logger.info("Departments employee data uploaded Successfully");
//		} catch (Exception e) {
//			logger.info(e);
//		}
		
	}
	

}
