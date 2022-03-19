package com.prueba.provider.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel(description = "Request when create a signMethod")
public class SignMethodRequest  {
	@ApiModelProperty(notes = "Key from authentication", example = "did:ev:eiurhtnugtrgjrt" )
    private String key;
	
	@ApiModelProperty(notes = "type from signMethod", example = "did" )
    private String type;
	
	@ApiModelProperty(notes = "aditional data from for example password", example = "@12349483." )
    private String additionalData;
    	
	
}
