package com.mysqldatamigration.service;

import java.util.List;

import com.mysqldatamigration.model.Titles;

public interface TitleService {
	
	public void addTitle(Titles title);
	public List<Titles> getTitles(Integer empNumber);

}
