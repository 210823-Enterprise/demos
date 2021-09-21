package com.revature.aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonJoinPointConfig {

	@Pointcut("execution(* com.revature.business.*.*(..))")
	public void businessLayerExecution() {}
	
	// Now we just pass this the qualified name of the method as the point cut to specific aspects
	
	@Pointcut("execution(* com.revature.data.*.*(..))")
	public void dataLayerExecution() {}
	
	@Pointcut("com.revature.aspect.CommonJoinPointConfig.dataLayerExecution() && com.revature.aspect.CommonJoinPointCutConfig.businessLayerExecution()")
	public void allLayerExecution() {}
	
	// intercept point cuts based on Bean names
	@Pointcut("bean(*dao*)")
	public void beanContainingDao() {}
	
	@Pointcut("within(com.revature.data..*)")
	public void dataLayerExecutionWithin() {} 
	
	@Pointcut("@annotation(com.revature.annotaion.TrackTime)")
	public void trackTimeAnnotation() {}
	
	
	
	
	
	
	
	
}
