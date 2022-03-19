			package com.prueba.provider.error;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 2329765667676467946L;

	private HttpStatus httpStatus;
	private String statusCode; 
	
	public GeneralRuntimeException(HttpStatus httpStatus, String statusCode, String message) {
		super(message);
		
		this.httpStatus = httpStatus;
		this.statusCode = statusCode;
	}

}