package com.luv2code.springdemo;

import java.util.Random;

public class LuckyForturnService implements FortuneService {
	
	private String[] randomStrings = {
			"Joe waited for the train train",
			"The train was late",
			"Mary and Samantha took the bus"
	};

	@Override
	public String getForitune() {
		Random random = new Random();
		
		int randomInt = random.nextInt(randomStrings.length);
		
		System.out.println("Random int = " + randomInt);
		
		return 	randomStrings[randomInt];
	}

}
