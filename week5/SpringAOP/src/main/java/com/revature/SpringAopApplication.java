package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.business.Business1;
import com.revature.business.Business2;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// we need to inject the beans into this class in order to use them
	@Autowired
	private Business1 business1;
	
	@Autowired
	private Business2 business2;

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// call the calculateSomething() methods from the  business layer
		
		logger.info(business1.calculateSomething());
		logger.info(business2.calculateSomething());
		
		// GOall: write any calls made to the business layer and intercept them
		
		
	}
	

}
