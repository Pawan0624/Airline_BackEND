package com.wipro.velocity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//		generateData(context);
	}

//	private static void generateData(ConfigurableApplicationContext context) {
//		FlightRestController restController = context.getBean(FlightRestController.class);
//		restController.createFlight(new Flight());
//	}
}
