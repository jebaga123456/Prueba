package com.prueba.provider.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.prueba.provider.response.HttpResponse;

@ControllerAdvice
public class DomainExceptionAdvice {

	@ExceptionHandler(GeneralRuntimeException.class)
	public final ResponseEntity<HttpResponse<String>> handleDomainException(GeneralRuntimeException exc,
			HttpServletRequest exchange) {

		HttpResponse<String> re = new HttpResponse<String>(exc.getHttpStatus().value(), exc.getStatusCode(), exc.getMessage());
		
//		final var status = c;
//		final var httpStatus = exc.getHttpStatus();
	    //final var request = exchange.getRequest();
	    
//	    if(httpStatus.is5xxServerError()) {
//	    	return ResponseEntity.status(httpStatus).body(new HttpResponse<String>(httpStatus.value(), null, exc.getMessage()));
//	    }
//
//	    if(httpStatus.is4xxClientError()) {
//	    	return  ResponseEntity.status(httpStatus).body(new HttpResponse<String>(httpStatus.value(), null, exc.getMessage()));
//	    }
	   
		return ResponseEntity.status(exc.getHttpStatus()).body(re);

	}

}