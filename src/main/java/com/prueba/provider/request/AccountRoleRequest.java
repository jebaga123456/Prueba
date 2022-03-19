package com.prueba.provider.request;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel(description = "Request when create an account")
public class AccountRoleRequest  {


	@ApiModelProperty(value="roles from user", example = "ROLE : [ROLE_ADMIN] ", required = true)
	private List<String> roles;
    		
}
