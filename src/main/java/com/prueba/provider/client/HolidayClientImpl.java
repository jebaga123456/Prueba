package com.prueba.provider.client;

import java.net.URI;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.prueba.provider.client.response.HolidayDto;
import com.prueba.provider.error.GeneralRuntimeException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class HolidayClientImpl  implements HolidayClient{

	
	public List<HolidayDto> getHoliday() {
		
		RestTemplate restTemplate = new RestTemplate();
		
        URI targetUrl = UriComponentsBuilder.fromUriString("https://feriados-cl-api.herokuapp.com/") // Build the base link
                .path("feriados") // Add path
                ///.queryParam("userId", userId) // Add one or more query params                
                .build() // Build the URL
                .encode() // Encode any URI items that need to be encoded
                .toUri();

        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
            ResponseEntity<List<HolidayDto>> response = restTemplate.exchange(targetUrl, HttpMethod.GET,
                    new HttpEntity<>(headers), new ParameterizedTypeReference<List<HolidayDto>>() {});

            List<HolidayDto> body = response.getBody();
            if (response.getStatusCode() != HttpStatus.OK && body != null) {

                throw new GeneralRuntimeException(response.getStatusCode(),"","" );

            }
            
            return body;


	}
	
}
