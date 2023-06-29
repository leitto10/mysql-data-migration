package com.mysqldatamigration;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mysqldatamigration.model.Salaries;
import com.mysqldatamigration.model.Titles;
import com.mysqldatamigration.phases.Phase1;
import com.mysqldatamigration.phases.Phase2;
import com.mysqldatamigration.service.SalaryService;
import com.mysqldatamigration.service.TitleService;


@SpringBootApplication
public class MysqlDataMigrationApplication implements CommandLineRunner {
	public static final Log logger = LogFactory.getLog(MysqlDataMigrationApplication.class);
	
	@Autowired
	public Phase1 phaseOne;
	
	@Autowired
	public Phase2 phaseTwo;
	
	@Autowired
	public SalaryService salaryService;
	
	@Autowired
	public TitleService titleService;
	

	public static void main(String[] args) {
		SpringApplication.run(MysqlDataMigrationApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
//		this.phaseOne.executeToFile("2000-01-01", "2000-12-31", "file.json");
		
//		this.phaseTwo.executeToTable();
		
//		List<Salaries> getSalaries = salaryService.getEmployeeSalaries(47291);
//		
//		for(Salaries salary: getSalaries) {
//			logger.info(salary);
//		}
		
		Titles title = titleService.getTitle(227544);
		logger.info(title);
	}
	
	
}








