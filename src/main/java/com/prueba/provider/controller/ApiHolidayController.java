package com.prueba.provider.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.prueba.provider.response.HolidayResponse;
import com.prueba.provider.response.HttpResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value = "Managment ", tags = {"Managment Holiday"})
public interface ApiHolidayController {
	
	   @ApiOperation(
	            value = "Save Holiday",
	            produces = MediaType.APPLICATION_JSON_VALUE,
	            consumes = MediaType.APPLICATION_JSON_VALUE, 
	            httpMethod = "POST" 
	            )
	    @ApiResponses(value = {    		
       		 @ApiResponse(code = 200, message = "ok"),
               @ApiResponse(code = 401, message = "User Not authorized"),
               @ApiResponse(code = 403, message = "Access to the requested resource is forbidden"),
               @ApiResponse(code = 404, message = "Endpoint Not Found")
      })
	  ResponseEntity<HttpResponse<HolidayResponse>> saveHoliday( );	   
}
