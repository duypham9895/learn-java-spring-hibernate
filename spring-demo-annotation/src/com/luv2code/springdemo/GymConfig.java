package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GymConfig {
	
	// define bean for out lucky fortune service
	@Bean
	public FortuneService luckyFortuneService() {
		return new LuckyFortuneService();
	}
	
	// define bean for gym coach
	@Bean
	public Coach gymCoach() {
		return new GymCoach(luckyFortuneService());
	}

}
