package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		Coach theCoach2 = context.getBean("tennisCoach", Coach.class);

		// check if they are the same
		boolean result = theCoach == theCoach2;

		// print out the result
		System.out.println("Pointing to the same object: " + result);

		System.out.println("Memory location for theCoach: " + theCoach);

		System.out.println("Memory location for theCoach2: " + theCoach2);

		// context close
		context.close();

	}

}
