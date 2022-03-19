package com.prueba.provider.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.prueba.provider" })
@Import(Swagger2Config.class)
public class AppConfig  extends WebMvcConfigurerAdapter{


@Override
public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new LocaleChangeInterceptor());
}

@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("swagger-ui.html")
         .addResourceLocations("classpath:/META-INF/resources/");

       registry.addResourceHandler("/webjars/**")
         .addResourceLocations("classpath:/META-INF/resources/webjars/");
}
}