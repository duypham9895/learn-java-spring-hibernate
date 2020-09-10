package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.entity.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account, boolean flag) {

		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");

	}

	public boolean doWord() {
		System.out.println(getClass() + ": doWork()");

		return false;
	}

}
