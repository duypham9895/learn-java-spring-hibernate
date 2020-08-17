package com.luv2code.springdemo;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class LuckyFortuneService implements FortuneService {

	private Random random = new Random();

	@Override
	public String getFortune() {
		ArrayList<String> newData = new ArrayList<>();
		try {
			File myObj = new File(
					"/Users/duypham/Documents/Study/Programming/Web_Development/JAVA/spring-demo-annotation/src/data.txt");
			Scanner myReader = new Scanner(myObj);

			while (myReader.hasNextLine()) {
				newData.add(myReader.nextLine());
			}

			myReader.close();
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		int num = random.nextInt(newData.size());

		return newData.get(num);
	}

}
