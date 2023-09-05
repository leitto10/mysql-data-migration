package com.mysqldatamigration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysqldatamigration.model.Titles;
import com.mysqldatamigration.repository.TitleRepository;


@Service("titleService")
public class TitleServiceImpl implements TitleService {
	
	@Autowired
	private TitleRepository titleRepository;

	@Override
	public List<Titles> getTitles(Integer empNumber)  {
		return titleRepository.getTitles(empNumber);
	}

	@Override
	public void addTitle(Titles title) {
		titleRepository.addTitle(title);
		
	}

}
