package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// Aspect
@Aspect
// Configuration
@Configuration // declares something that will interact with beans in the Spring App
public class BeforeAspect {

	// logger
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// define what type of method to intercept and WHEN (before)
	@Before("execution(* com.revature.business.*.*(..))") // we have provided a Pointcut
	public void before(JoinPoint joinPoint) { 
		
		// define what we DO when we intercept the method
		logger.info("Intercepted Method call {}", joinPoint);
		
		// Aspect = pointcut + advice
		// JoinPoint = the object being affected by the aspect
	}
	

	// logging some info about what we return when we intercept the method

}
