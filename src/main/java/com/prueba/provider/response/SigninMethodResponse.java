package com.prueba.provider.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Response when create a signMethod")
public class SigninMethodResponse {
	
	@ApiModelProperty(notes = "Id from a signMethod", example = "9j98345395u" )
    private Long id;
	
	@ApiModelProperty(notes = "Key from authentication", example = "did:ev:eiurhtnugtrgjrt" )
    private String key;
	
	@ApiModelProperty(notes = "type from signMethod", example = "did" )
    private String type;
	
	@ApiModelProperty(notes = "aditional data from for example password", example = "@12349483." )
    private String additionalData;
	
	@ApiModelProperty(notes = "Id from account", example = "990384" )
    private String accountId; 
}
