package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GymJavaConfigDemoApp {

	public static void main(String[] args) {
		// read spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GymConfig.class);

		// get the bean from spring container
		GymCoach theCoach = context.getBean("gymCoach", GymCoach.class);

		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		// call a method to get daily fortune
		System.out.println(theCoach.getDailyFortune());

		// close the context
		context.close();

	}

}
