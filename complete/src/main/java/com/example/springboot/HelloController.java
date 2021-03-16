package com.example.springboot;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class HelloController {

	Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private Environment env;

	
	@RequestMapping("/")
	public String index() {

        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
        String whichEnv = env.getProperty("spring.profiles.active");
         
		//return "Greetings from GoToProd App. I am last updated on 03/15 in " + whichEnv + " Environment";

        return "Greetings from GoToProd App. I am last updated on 03/15 ";
	}

}
