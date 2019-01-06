package com.production.spring.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.production.annotation.WebController;

import com.production.annotation.RestEndpoint;


@Configuration
@EnableWebMvc
@ComponentScan(
        basePackages = {"com.production.spring.site", "com.production.spring.csr", "com.production.validation", "com.production.restful"},
        useDefaultFilters = false,
        includeFilters = @ComponentScan.Filter(WebController.class) 
        //, @ComponentScan.Filter(RestEndpoint.class), @ComponentScan.Filter(RestController.class)
)
public class WebServletContextConfiguration extends WebMvcConfigurerAdapter
{
	// only includes controllers 
	@Inject SpringValidatorAdapter validator;
	
	
    @Override
    public Validator getValidator()
    {
        return this.validator;
    }
 
	
	
	
    @Bean
    public ViewResolver viewResolver()
    {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }	
	
}






