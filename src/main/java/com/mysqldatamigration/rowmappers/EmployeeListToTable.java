package com.mysqldatamigration.rowmappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import com.mysqldatamigration.model.Employees;
import com.mysqldatamigration.model.Gender;
import com.mysqldatamigration.utils.DateConver;

public class EmployeeListToTable {
	
	// Takes JSON array and maps them into an Employee list
	public List<Employees> jsonArrayToList(JSONArray jsonArray) throws JSONException {
		List<Employees> employeeList = new ArrayList<>();
		
		for(int i = 0; i < jsonArray.length()-1; i++) {
			DateConver dateConverter = new DateConver();
			Employees employee = new Employees();
			JSONObject currJson = jsonArray.getJSONObject(i);
			
			employee.setEmpNo(currJson.getInt("emp_no"));
			
			if(!currJson.isNull("birth_date")) {
				java.sql.Date birthDate = dateConverter.stringToSqlDate(currJson.getString("birth_date"));
				employee.setBirthDate(birthDate);
			}
			
			if(!currJson.isNull("first_name")) {
				employee.setFirstName(currJson.getString("first_name"));
			}
			
			if(!currJson.isNull("last_name")) {
				employee.setLastName(currJson.getString("last_name"));
			}
			
			if(!currJson.isNull("gender")) {
				employee.setGender(Gender.valueOf(currJson.getString("gender")));
			}
			
			if(!currJson.isNull("hire_date")) {
				java.sql.Date hireDate = dateConverter.stringToSqlDate(currJson.getString("hire_date"));
				employee.setHireDate(hireDate);
			}
			
			employeeList.add(employee);
		}
		
		return employeeList;
	}

}
