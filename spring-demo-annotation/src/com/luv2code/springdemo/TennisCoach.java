package com.luv2code.springdemo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements Coach, DisposableBean {

	@Value("${foo.email}")
	private String email;

	@Value("${foo.team}")
	private String team;

	private FortuneService fortuneService;

	// define a default constructor
	public TennisCoach() {
		System.out.println(">>> TennisCoach: inside default constructor");
	}

	@Autowired
	public TennisCoach(@Qualifier("luckyFortuneService") FortuneService theFortuneService) {

		System.out.println(">>> TennisCoach: inside constructor using @autowired and @qualifier");

		fortuneService = theFortuneService;
	}

	/*
	 * // define a setter method
	 * 
	 * @Autowired public void setForturnService(FortuneService forturnService) {
	 * System.out.println(">>> TennisCoach: inside setForturnService() method");
	 * this.forturnService = forturnService; }
	 * 
	 * 
	 * @Autowired public void doSomeCrazy(FortuneService forturnService) {
	 * System.out.println(">>> TennisCoach: inside doSomeCrazy() method");
	 * this.forturnService = forturnService; }
	 */

	/*
	 * @Autowired public TennisCoach(FortuneService forturnService) {
	 * this.forturnService = forturnService; }
	 */

	@PostConstruct
	public void doStartupStuff() {
		System.out.println(">>> TennisCoach: inside doStartupStuff() method");
	}

//	@PreDestroy
//	public void doCleanupStuff() {
//		System.out.println(">>> TennisCoach: inside doCleanupStuff() method");
//	}

	@Override
	public void destroy() throws Exception {
		System.out.println(">>> TennisCoach: inside doCleanupStuff() method");

	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice your backhand volley";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
