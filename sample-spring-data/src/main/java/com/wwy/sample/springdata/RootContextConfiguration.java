package com.wwy.sample.springdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;



/***
 * 根上下文配置
 * 
 * @author 文尧
 *
 */
@Configuration
@ComponentScan(basePackageClasses={RootContextConfiguration.class},excludeFilters = @ComponentScan.Filter({ Controller.class,
		ControllerAdvice.class }))
public class RootContextConfiguration {
	private static final Logger log = LoggerFactory.getLogger(RootContextConfiguration.class);

	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/**
	 * 实体验证
	 * 
	 * @return
	 */
	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		return validator;
	}

	/***
	 * 
	 * @return
	 */
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_INDEX);
		objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, true);
		return objectMapper;
	}



	



}
