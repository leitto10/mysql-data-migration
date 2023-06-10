package com.mysqldatamigration;

import java.sql.Connection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MysqlDataMigrationApplication {
	private static final Log logger = LogFactory.getLog(MysqlDataMigrationApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MysqlDataMigrationApplication.class, args);
	}

}
