package com.example.springboot;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootApplication
public class Application implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	@Autowired
    private Environment env;

	@Autowired
    private Config config;


	@Override
    public void run(String... args) throws Exception {

		
        logger.info("{}", env.getProperty("JAVA_HOME"));
        logger.info("{}", env.getProperty("spring.application.name"));
		logger.info("{}", env.getProperty("spring.profiles.active"));

		//getting data from YAML: 
		System.out.println(config);

    }

	public static void main(String[] args) {
        
		logger.info("this is a info message");
		logger.warn("this is a warn message");
		logger.error("this is a error message");
		
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			
			System.out.println("Let's inspect the beans provided by Spring Boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

}
