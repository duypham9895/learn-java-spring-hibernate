package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
