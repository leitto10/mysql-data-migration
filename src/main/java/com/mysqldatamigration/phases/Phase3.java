package com.mysqldatamigration.phases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

import com.mysqldatamigration.model.Salaries;
import com.mysqldatamigration.model.Titles;
import com.mysqldatamigration.service.SalaryService;
import com.mysqldatamigration.service.TitleService;


@Component
public class Phase3 {
	public static final Log logger = LogFactory.getLog(Phase3.class);
	
	@Autowired
	public SalaryService salaryService;
	
	@Autowired
	public TitleService titleService;
	
	public void excutePhase3() throws Exception {
		logger.info("Running phase 3...");
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
		} else {
			logger.info("The file doesn't exits...");
		}
		
		this.uploadTitleData(jsonArray);
	}
	
	public void uploadTitleData(JSONArray jsonArray) throws Exception {
		List<Integer> salariesList = new ArrayList<>();
		List<Integer> titlesList = new ArrayList<>();
		
		for(int i=0; i<jsonArray.length()-1; i++) {
			JSONObject currJson = jsonArray.getJSONObject(i);
			salariesList.add(currJson.getInt("emp_no"));
			titlesList.add(currJson.getInt("emp_no"));
		}
		
		List<Salaries> getSalaries = new ArrayList<>();
		for(Integer salary: salariesList) {
			getSalaries.addAll(salaryService.getEmployeeSalaries(salary));
		}

		System.out.println("Uploading salaries data: \n");
		System.out.println("Salaries list size: "+getSalaries.size());
		for(Salaries salary: getSalaries) {
			salaryService.addSalary(salary);
			logger.info(salary);
		}
		
		List<Titles> getTitlesData = new ArrayList<>();
		for(Integer title: titlesList) {
			getTitlesData.add(titleService.getTitle(title));
		}
		
		System.out.println("Uploading titles data: \n");
		System.out.println("Titles list size: "+titlesList.size());
		for(Titles title: getTitlesData) {
			titleService.addTitle(title);
			logger.info(title);
		}
		
	}
}
