package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
