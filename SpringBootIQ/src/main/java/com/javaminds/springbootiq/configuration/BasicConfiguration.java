package com.javaminds.springbootiq.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component
@ConfigurationProperties("basic")
@Data
public class BasicConfiguration {
	
	private boolean value;
	private String message;
	private int number;
	

}
