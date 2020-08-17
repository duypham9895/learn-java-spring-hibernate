package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class GymCoach implements Coach {

	private FortuneService fortuneService;

	public GymCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Go to the gym and workout really hard about 2 hours";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

}
