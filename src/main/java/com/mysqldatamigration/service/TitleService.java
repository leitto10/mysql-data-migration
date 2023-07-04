package com.mysqldatamigration.service;

import com.mysqldatamigration.model.Titles;

public interface TitleService {
	
	public void addTitle(Titles title);
	public Titles getTitle(Integer empNumber);

}
