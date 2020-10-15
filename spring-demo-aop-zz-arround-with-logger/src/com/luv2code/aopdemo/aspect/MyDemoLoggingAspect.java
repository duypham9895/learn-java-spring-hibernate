package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.entity.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	private static Logger logger = Logger.getLogger(MyDemoLoggingAspect.class.getName());

	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		// print out the method we are advising on
		String method = proceedingJoinPoint.getSignature().toShortString();
		logger.info("\n====>>>> Executing @Around on method = " + method);

		// get begin time stamp
		long begin = System.currentTimeMillis();

		// let's execute the method
		Object result = proceedingJoinPoint.proceed();

		// get the end time stamp
		long end = System.currentTimeMillis();

		// compute duration and display it
		long duration = end - begin;
		logger.info("=====>>>> Duration: " + duration / 1000.0 + " secs");

		return result;
	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n====>>>> Executing @After (finally) on method = " + method);
	}

	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "exc")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n====>>>> Executing @AfterThrowing on method = " + method);

		// log the exception
		logger.info("\n====>>>> The exception is = " + exc);
	}

	// add a new advice for @AfterReturning on the findAccounts() method
	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n====>>>> Executing @AfterReturning on method = " + method);

		// print out the results of the method call
		logger.info("\n====>>>> result is = " + result);

		// let's post-process the data
		// convert the account names to upper case
		convertAccountNamesToUpperCase(result);

		logger.info("\n====>>>> result is = " + result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		// loop through account
		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}

	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		logger.info("====>>> Executing @Before advice on method()");

		// display a method signature
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();

		// display method arguments
		logger.info("Method: " + methodSig);

		// get args
		Object[] args = joinPoint.getArgs();

		// loop through args
		for (Object arg : args) {
			logger.info(arg.toString());

			if (arg instanceof Account) {
				// downcast and print Account specific stuff
				Account account = (Account) arg;
				logger.info("Account Name = " + account.getName());
				logger.info("Account Level = " + account.getLevel());
			}
		}
	}

}
