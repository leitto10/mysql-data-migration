package com.mysqldatamigration.utils;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConver {
	
	public String dateToString(Date date) {
		DateFormat df2 = new SimpleDateFormat("yyyyMMdd'T'HH:mm:ss");
		String toString = null;
		
		if(date != null) {
			toString = df2.format(date);
		}
		
		return toString;
	}
	
	public Date stringToSqlDate(String str) {
		DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
		java.util.Date utilsDate = null;
	    Date sqlDate = null;
	    
	    if(str != null) {
	    	try {
				utilsDate = df2.parse(str);
		    	sqlDate = new java.sql.Date(utilsDate.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
	    }
	    
	    return sqlDate;
	}
	

}
