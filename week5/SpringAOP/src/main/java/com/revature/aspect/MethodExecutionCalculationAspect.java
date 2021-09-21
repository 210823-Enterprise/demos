package com.revature.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// configuration & Aspect
@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());


	/**
	 * @throws Throwable 
	 * @Around is an advice type which ensures that an advice can
	 * 			rund before and after method execution
	 */
	
	// Now this advice can only be applied to methods marked with @TrackTime 
	@Around("com.revature.aspect.JoinPointCutConfig.trackTimeAnnotation()")
	public void around(ProceedingJoinPoint pJoinPoint) throws Throwable {
		
		// capture the start time of the method
		long start = System.currentTimeMillis();
		
		// we have to give the method permission to continue executing
		pJoinPoint.proceed();
		
		// capture the end time of the method 
		long timeTaken = System.currentTimeMillis() - start;
	
		// log the difference
		logger.info("Time taken by {} is {}", pJoinPoint, timeTaken);
		
	}
	
	// Goal: have this aspect intercept any method that is annotated with a custom annotation

	
	
	
}
