package com.example;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.shell.jline.PromptProvider;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;

/**
 * 
 * Notice below that the @EnableAutoConfiguration annotation used (indirectly) for this class tells 
 * Spring Boot to “guess” how you want to configure Spring, based on the jar dependencies that you have added. 
 * Since spring-boot-starter-web added Tomcat and Spring MVC, the auto-configuration assumes that 
 * you are developing a web application and sets up Spring accordingly. 
 * 
 * Note: This class implements Spring Boot’s CommandLineRunner, which means during startup, Spring will 
 * execute the run() method after the application context is loaded up.
 * 
 * Autodiscovery is performed by Spring using the @ComponentScan which looks at classes that use
 * special stereotype annotations: @Component, @Controller, @Repository, @Service, @Configuration
 * 
 * The H2 In-Memory Database Console is enable and can be reached here: http://localhost:7070/h2-console
 * 
 * Also note that multiple CommandLineRunner run() methods can be executed as demonstrated below
 * This Spring web Application also has a WebListener configured using @ServletComponentScan annotation
 * 
 * @author kulkarvi
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
