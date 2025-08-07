package com.example.userprofile.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomAspect.class);
	
	 @After("execution(* com.example.userprofile.service.*.*(..))")
	    public void logBefore(JoinPoint joinPoint) {
	        System.out.println("Before method: " + joinPoint.getSignature().getName());
	        logger.info(joinPoint.getSignature().getName()+" method run completed");
	    }
}
