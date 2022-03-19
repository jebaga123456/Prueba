package com.prueba.provider.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.prueba.provider.dao.HolidayDao;
import com.prueba.provider.model.Holiday;
import com.prueba.provider.service.HolidayService;


import lombok.extern.slf4j.Slf4j;

@Service

@Slf4j

public class HolidayServiceImpl implements HolidayService {

	
	@Autowired
	HolidayDao holidayDao;
	
	public List<Holiday> saveHoliday() {
				
		
		return holidayDao.createHoliday();
	}
	
}
