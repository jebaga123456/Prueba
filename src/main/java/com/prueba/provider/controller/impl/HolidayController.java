package com.prueba.provider.controller.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.prueba.provider.controller.ApiHolidayController;
import com.prueba.provider.response.HolidayResponse;
import com.prueba.provider.response.HttpResponse;
import com.prueba.provider.service.HolidayService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/holiday")
@CrossOrigin(origins = "*")
@Slf4j
public class HolidayController implements ApiHolidayController {

	@Autowired
	HolidayService dataService;

	@PostMapping("/")	
	@Override
	public ResponseEntity<HttpResponse<HolidayResponse>> saveHoliday (){

		String xCorrelantionId = UUID.randomUUID().toString();

		dataService.saveHoliday();
		log.info("DataController: list : xCorrelantionId:{} ", xCorrelantionId);
		ResponseEntity<HttpResponse<HolidayResponse>> res = ResponseEntity
				.ok(new HttpResponse<HolidayResponse>(HttpStatus.OK.value(),
						new HolidayResponse("" ), HttpStatus.OK.getReasonPhrase() ));
		

		return res;
	}


	
}
