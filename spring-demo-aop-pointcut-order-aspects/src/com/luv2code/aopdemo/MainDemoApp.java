package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.entity.Account;

public class MainDemoApp {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// Call business method Account
		accountDAO.addAccount(new Account(), true);
		accountDAO.doWord();

		// Call AccountDAO getter/setter methods
		accountDAO.setName("DUY");
		accountDAO.setCode("123ABC");

		String name = accountDAO.getName();
		String code = accountDAO.getCode();

		// Call business method Membership
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();

		context.close();

	}

}
