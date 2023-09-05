package com.mysqldatamigration;


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
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import com.mysqldatamigration.phases.PhaseOne;
import com.mysqldatamigration.phases.PhaseThree;
import com.mysqldatamigration.phases.PhaseTwo;


@SpringBootApplication
public class MysqlDataMigrationApplication implements CommandLineRunner {
	public static final Log logger = LogFactory.getLog(MysqlDataMigrationApplication.class);
	
	@Autowired
	public PhaseOne phaseOne;
	
	@Autowired
	public PhaseTwo phaseTwo;
	
	@Autowired
	public PhaseThree phaseThree;
	
	

	public static void main(String[] args) {
		SpringApplication.run(MysqlDataMigrationApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		String fileName = "2020-01.json";
		String startDate = "1985-01-01";
		String endDate = "2000-01-28";
		
//		this.phaseOne.executeToFile(startDate, endDate, fileName);
//		this.phaseTwo.executeToTable(fileName);	
		this.phaseThree.excutePhase3(fileName);
		
	}
	
}








