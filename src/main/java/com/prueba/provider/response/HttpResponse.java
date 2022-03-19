package com.prueba.provider.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class HttpResponse<T> {

	private int status;
	
	private T data;
 
	private String message;

}
