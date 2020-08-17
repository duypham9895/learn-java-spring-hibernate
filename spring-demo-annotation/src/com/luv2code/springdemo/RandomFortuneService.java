package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create an array of string
	private String[] data = { "Joe waited for the train train", "The train was late",
			"Mary and Samantha took the bus" };

	// create a random number generator
	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		// pick a random string from the array
		int num = myRandom.nextInt(data.length);

		return data[num];
	}

}
