package com.mysqldatamigration.rowmappers;

import java.util.LinkedHashMap;

import com.mysqldatamigration.model.Employees;
import com.mysqldatamigration.utils.DateConver;

public class EmployeeToMap {
	
	private DateConver date = null;
	
	public LinkedHashMap<String, Object> getMapFromEmployee(LinkedHashMap<String, Object> map, Employees emplooyee) {
		date = new DateConver();
		map.put("emp_no", emplooyee.getEmpNo());
		map.put("birth_date", (emplooyee.getBirthDate() == null ? null : date.dateToString(emplooyee.getBirthDate() )));
		map.put("first_name", emplooyee.getFirstName());
		map.put("last_name", emplooyee.getLastName());
		map.put("gender", emplooyee.getGender());
		map.put("hire_date", (emplooyee.getHireDate() == null ? null : date.dateToString(emplooyee.getHireDate())));
		return map;
	}

}
