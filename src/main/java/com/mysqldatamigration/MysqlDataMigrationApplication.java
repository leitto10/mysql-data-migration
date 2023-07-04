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

import com.mysqldatamigration.phases.Phase1;
import com.mysqldatamigration.phases.Phase2;
import com.mysqldatamigration.phases.Phase3;


@SpringBootApplication
public class MysqlDataMigrationApplication implements CommandLineRunner {
	public static final Log logger = LogFactory.getLog(MysqlDataMigrationApplication.class);
	
	@Autowired
	public Phase1 phaseOne;
	
	@Autowired
	public Phase2 phaseTwo;
	
	@Autowired
	public Phase3 phaseThree;
	
	

	public static void main(String[] args) {
		SpringApplication.run(MysqlDataMigrationApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		this.phaseOne.executeToFile("2000-01-01", "2000-12-31", "file.json");
		
//		this.phaseTwo.executeToTable();
		
//		this.phaseThree.excutePhase3();
		
	}
	
}








