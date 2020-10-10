package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.entity.Account;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call method to find the accounts
		List<Account> accounts = null;

		try {
			// add a boolean flag to simulate exception
			boolean flag = false;
			
			accounts = accountDAO.findAccounts(flag);
		} catch (Exception e) {
			System.out.println("\nMain Program ... caught exception: " + e);
		}

		// display the accounts
		System.out.println("\nMain Program: AfterFinallyDemoApp");
		System.out.println("-----");

		System.out.println(accounts);

		System.out.println("\n");

		context.close();

	}

}
