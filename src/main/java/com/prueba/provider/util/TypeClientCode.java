package com.prueba.provider.util;

import lombok.Getter;


@Getter
public enum TypeClientCode {

	CLIENT_EVERIS("CLIENT_123","https://ok_url")
	;	
	
    
	private String client_id;
	private String uri;

    TypeClientCode(String client_id, String uri) {
        this.client_id = client_id;
        this.uri = uri;
    }
}
