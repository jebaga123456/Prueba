package com.prueba.provider.client;

import org.springframework.retry.annotation.Retryable;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.prueba.provider.client.response.HolidayDto;

import java.util.List;

import org.springframework.retry.annotation.Backoff;

public interface HolidayClient {

    @Retryable(value = { HttpServerErrorException.class,HttpClientErrorException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    List<HolidayDto> getHoliday();
    
        
    }
