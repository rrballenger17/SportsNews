package com.production.spring.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Controller;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.production.annotation.RestEndpoint;
import com.production.annotation.WebController;

import org.hibernate.validator.HibernateValidator;

@Configuration
@ComponentScan(
        basePackages = {"com.production.spring.site", "com.production.spring.csr", "com.production.validation", "com.production.restful"},
        excludeFilters = {@ComponentScan.Filter(WebController.class), @ComponentScan.Filter(RestEndpoint.class), @ComponentScan.Filter(RestController.class)}
)
@EnableAsync(proxyTargetClass = true)
@EnableScheduling
public class RootContextConfiguration implements AsyncConfigurer, SchedulingConfigurer
{
	
    // required
    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean()
    {        
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setProviderClass(HibernateValidator.class);
        return validator;
    }
    
    // required
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor()
    {
        MethodValidationPostProcessor processor =
                new MethodValidationPostProcessor();
        processor.setValidator(this.localValidatorFactoryBean());
        return processor;
    }
 
	
	
    @Bean
    public ThreadPoolTaskScheduler taskScheduler()
    {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(20);
        scheduler.setThreadNamePrefix("task-");
        scheduler.setAwaitTerminationSeconds(60);
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        return scheduler;
    }
    
    @Bean
    public ObjectMapper objectMapper()
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        return mapper;
    }
    
    @Bean
    public Jaxb2Marshaller jaxb2Marshaller()
    {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(new String[] { "com.production" });
        return marshaller;
    }
 

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		// TODO Auto-generated method stub
        TaskScheduler scheduler = this.taskScheduler();
        taskRegistrar.setTaskScheduler(scheduler);
	}

	@Override
	public Executor getAsyncExecutor() {
		// TODO Auto-generated method stub
        Executor executor = this.taskScheduler();
        return executor;
	}
}
