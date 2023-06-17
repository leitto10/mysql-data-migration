package com.mysqldatamigration.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class MySqlSource {
	
	private String password;
	private String username;
	private String host;
	
	public Connection con;
	
	public static final Log logger = LogFactory.getLog(MySqlSource.class);
	
	
	public void connection() {
		try {
			String mySqlUrl = "jdbc:mysql://localhost:3306/employees?"+
					"user=root&password=North2@21&serverTimeZone=UTC";
			
			con = DriverManager.getConnection(mySqlUrl);
			
			if(con == null) {
				logger.info("Can't access database using + "+ mySqlUrl);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public void clonseConnection() {
		this.clonseConnection();
	}

}
