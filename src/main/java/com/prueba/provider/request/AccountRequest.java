package com.prueba.provider.request;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel(description = "Request when create an account")
public class AccountRequest  {

	@ApiModelProperty(value="account id from user", example = "user100", required = true)	  
	private String accountId;
	
	@ApiModelProperty(value="roles from user", example = "ROLE : [ROLE_ADMIN] ", required = false)
	private List<String> roles;
    		
}
