package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@AfterReturning(
			value="execution(* com.revature.business.*.*(..))",
			returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		
		logger.info("{} returned with value {}", joinPoint, result);
		
	}
	
	// we use after typically to check a return value or to check if an exception has been thrown by a method
	
	@AfterThrowing( // 
			value="com.revature.aspect.CommonJoinPointConfig.businessLayerExecution()",
                   throwing="exception")
	public void afterThrowing(JoinPoint joinPoint, Object exception) {
	
		logger.info("{} throws the exception {}", joinPoint, exception);
		
	}
	
	@After(value="com.revature.aspect.CommonJConfig.businessLayerExecution()")
	public void after(JoinPoint joinPoint) {
		
		logger.info("after execution of {}", joinPoint);
		
	}
	
	
	
	
	
	
	
	
	
}
