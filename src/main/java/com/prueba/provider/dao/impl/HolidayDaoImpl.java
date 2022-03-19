package com.prueba.provider.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.prueba.provider.client.HolidayClient;
import com.prueba.provider.client.response.HolidayDto;
import com.prueba.provider.dao.HolidayDao;
import com.prueba.provider.error.GeneralRuntimeException;
import com.prueba.provider.model.Holiday;
import com.prueba.provider.repository.DataRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class HolidayDaoImpl implements HolidayDao {

	@Autowired
	DataRepository dataRepository;
	
	@Autowired
	HolidayClient holidayClient;
	
	@Override
	public List<Holiday> createHoliday() 	{
		
		List<HolidayDto> listDTOHoliday= holidayClient.getHoliday();
		
	
		
		List<Holiday> listHoliday= new ArrayList<>();
		
		try {
		for (HolidayDto holidayDTO : listDTOHoliday) {
			
			Holiday holiday = new Holiday();
			Date date1 = null;
			/*
			
				date1 = new SimpleDateFormat("dd/MM/yyyy").parse("");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			holiday.setCreateDate(holidayDTO.getDate());
			holiday.setExtra(holidayDTO.getExtra());
			holiday.setTitle(holidayDTO.getTitle());
			listHoliday.add(holiday);
			
		}
				
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            throw new GeneralRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR,"",e.getMessage() );
			
		}
		
		return dataRepository.saveAll(listHoliday);
	}
	
}
