package com.eoi.es;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:english.properties")
public class LabelsEnglish implements Labels{
	
	@Value("${greeting}")
	private String greeting;

}
