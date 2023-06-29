package com.mysqldatamigration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysqldatamigration.model.Titles;
import com.mysqldatamigration.repository.TitleRepository;


@Service("titleService")
public class TitleServiceImpl implements TitleService {
	
	@Autowired
	private TitleRepository titleRepository;

	@Override
	public Titles getTitle(Integer empNumber) {
		return titleRepository.getTitle(empNumber);
	}

}
