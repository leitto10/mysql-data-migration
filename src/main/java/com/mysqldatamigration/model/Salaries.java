package com.mysqldatamigration.model;

import java.sql.Date;

public class Salaries {
	
	private Integer emp_no;
	private Integer salary;
	private Date fromDate;
	private Date toDate;
	
	public Integer getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(Integer emp_no) {
		this.emp_no = emp_no;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
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
		return "Salaries [emp_no=" + emp_no + ", salary=" + salary + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ "]";
	}

}
