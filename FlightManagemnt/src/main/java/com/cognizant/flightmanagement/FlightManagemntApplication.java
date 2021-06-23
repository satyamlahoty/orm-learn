package com.cognizant.flightmanagement;


import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.cognizant.flightmanagement.model.Flight;
import com.cognizant.flightmanagement.model.Passenger;
import com.cognizant.flightmanagement.serivce.FlightService;

import java.util.*;



@SpringBootApplication
@ComponentScan("com")
public class FlightManagemntApplication {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightManagemntApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(FlightManagemntApplication.class, args);
		LOGGER.info("IN MAIN");
		 
//		List<Passenger> p= new ArrayList<Passenger>();
		
		
		
		
		
		
	}

}
