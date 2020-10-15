package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger logger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		TrafficFortuneService forturnService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		logger.info("\nMain Progran: AroundDemoApp");
		logger.info("Calling getFortune");

		String data = forturnService.getFortune();
		logger.info("\nMy Fortune is " + data);

		logger.info("Finished");

		context.close();

	}

}
