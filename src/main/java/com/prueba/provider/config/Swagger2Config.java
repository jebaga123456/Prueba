package com.prueba.provider.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class Swagger2Config {

	@Bean
	public Docket api() {
	    return new Docket
	    		(DocumentationType.SWAGGER_2)
	    		.select()
	            .apis(RequestHandlerSelectors.any())
	            .paths(PathSelectors.any())
	            .build()
	            .apiInfo(getApiInfo());
	            ///.securitySchemes(Arrays.asList(apiKey()));	    
	}


	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("Prueba REST API")
				.description(" Managment REST API")
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("1.0.0")
				.build();
	}
	
	
	private ApiKey apiKey() {
	    return new ApiKey("Bearer", "Authorization", "header");
	}
}