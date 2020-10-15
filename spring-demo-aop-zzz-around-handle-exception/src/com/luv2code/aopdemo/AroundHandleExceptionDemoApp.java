package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		TrafficFortuneService forturnService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		logger.info("\nMain Progran: AroundDemoApp");
		logger.info("Calling getFortune");
		
		boolean tripWire = true;

		String data = forturnService.getFortune(tripWire);
		logger.info("\nMy Fortune is " + data);

		logger.info("Finished");

		context.close();

	}

}
