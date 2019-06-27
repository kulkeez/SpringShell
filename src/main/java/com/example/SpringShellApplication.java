package com.example;

import java.sql.Timestamp;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.shell.jline.PromptProvider;

import org.springframework.context.annotation.Bean;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;

/**
 * Simple example to understand how to create utilities using Spring Shell 
 * 
 * @author Vikram Kulkarni
 *
 */
//convenience annotation that adds @Configuration, @EnableAutoConfiguration, @ComponentScan
@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class SpringShellApplication {

	private static final Logger logger = LogManager.getLogger(SpringShellApplication.class);

	
	public static void main(String[] args) {
		logger.info("Launching the Spring Shell application ...");
		Timestamp tOne = new Timestamp(System.currentTimeMillis());

		SpringApplication.run(SpringShellApplication.class, args);
		
		logger.info("Launched Spring Shell application at time: " + tOne);
	}

	@Bean
    public PromptProvider myPromptProvider() {
        return () -> new AttributedString("hpe:>",
                AttributedStyle.DEFAULT.foreground(AttributedStyle.RED));
    }

}
