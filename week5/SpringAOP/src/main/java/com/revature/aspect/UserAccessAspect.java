package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// Set up the Configuration related to AOP
@Aspect
@Configuration
public class UserAccessAspect {

	// The point of this Aspect is so that we can check that the user obj 
	// has the right permissions to execute the method
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* com.revature.business.*.*(..))")
	public void before(JoinPoint joinPoint) {
		
		logger.info("Checking for user access");
		
		// some complex logic checking user credentials here ...
		
		// if everything is successful
		logger.info("Allowed Execution for {}", joinPoint);
	}
	
	// Weaving = the process of intercepting a method where we specify a pointcut (Spring AOP allows for this)
	// Weaver = the framework that does this (Spring AOP with the help of AspectJ)
	
}
