package com.prueba.provider.response;

public class GeneralResponse extends HttpResponse<String> {

	public GeneralResponse(int status, String data, String message) {
		super(status, data, message);
	}
	
	

}
