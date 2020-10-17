package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	// setup logger
	private Logger logger = Logger.getLogger(getClass().getName());

	// setup point-cut declarations
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
	}

	// do same thing for service & dao

	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
	}

	// add @Before advice
	@Before("forAppFlow()")
	private void before(JoinPoint joinPoint) {

		// display method we are calling
		String method = joinPoint.getSignature().toShortString();
		logger.info("======>>>>> in @Before: calling method: " + method);

		// display the arguments to the method
		// get the arguments
		Object[] args = joinPoint.getArgs();

		// loop through and display arguments
		for (Object arg : args) {
			logger.info("======>>>>> argument: " + arg);
		}
	}

	// add @AfterRunning advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {

		// display method we are returning
		String method = joinPoint.getSignature().toShortString();
		logger.info("======>>>>> in @AferReturning: from method: " + method);

		// display data returning
		logger.info("======>>>>> result: " + result);
	}

}
