package com.mysqldatamigration.utils;

import java.sql.Date;
import java.text.DateFormat;
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

}
