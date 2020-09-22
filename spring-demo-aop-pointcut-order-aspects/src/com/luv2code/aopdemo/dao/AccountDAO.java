package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.entity.Account;

@Component
public class AccountDAO {

	private String name;

	private String code;

	public void addAccount(Account account, boolean flag) {

		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");

	}

	public boolean doWord() {
		System.out.println(getClass() + ": doWork()");

		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getCode() {
		System.out.println(getClass() + ": in getCode()");
		return code;
	}

	public void setCode(String code) {
		System.out.println(getClass() + ": in setCode()");
		this.code = code;
	}

}
