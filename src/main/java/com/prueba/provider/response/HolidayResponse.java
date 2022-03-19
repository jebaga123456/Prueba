package com.prueba.provider.response;

import java.util.List;
import java.util.Set;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@ApiModel(description = "Response when create a account")
public class HolidayResponse {
	
	private  String response;

}
