package com.luv2code.aopdemo.aspect;

import java.util.List;

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

	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		// print out the method we are advising on
		String method = proceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n====>>>> Executing @Around on method = " + method);

		// get begin time stamp
		long begin = System.currentTimeMillis();

		// let's execute the method
		Object result = proceedingJoinPoint.proceed();

		// get the end time stamp
		long end = System.currentTimeMillis();

		// compute duration and display it
		long duration = end - begin;
		System.out.println("=====>>>> Duration: " + duration / 1000.0 + " secs");

		return result;
	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n====>>>> Executing @After (finally) on method = " + method);
	}

	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "exc")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n====>>>> Executing @AfterThrowing on method = " + method);

		// log the exception
		System.out.println("\n====>>>> The exception is = " + exc);
	}

	// add a new advice for @AfterReturning on the findAccounts() method
	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n====>>>> Executing @AfterReturning on method = " + method);

		// print out the results of the method call
		System.out.println("\n====>>>> result is = " + result);

		// let's post-process the data
		// convert the account names to upper case
		convertAccountNamesToUpperCase(result);

		System.out.println("\n====>>>> result is = " + result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		// loop through account
		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}

	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("====>>> Executing @Before advice on method()");

		// display a method signature
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();

		// display method arguments
		System.out.println("Method: " + methodSig);

		// get args
		Object[] args = joinPoint.getArgs();

		// loop through args
		for (Object arg : args) {
			System.out.println(arg);

			if (arg instanceof Account) {
				// downcast and print Account specific stuff
				Account account = (Account) arg;
				System.out.println("Account Name = " + account.getName());
				System.out.println("Account Level = " + account.getLevel());
			}
		}
	}

}
