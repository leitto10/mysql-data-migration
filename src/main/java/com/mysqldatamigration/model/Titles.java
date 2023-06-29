package com.mysqldatamigration.model;

import java.sql.Date;

public class Titles {
	
	private Integer empNo;
	private String title;
	private Date fromDate;
	private Date toDate;
	
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	@Override
	public String toString() {
		return "Titles [empNo=" + empNo + ", title=" + title + ", fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}

}
