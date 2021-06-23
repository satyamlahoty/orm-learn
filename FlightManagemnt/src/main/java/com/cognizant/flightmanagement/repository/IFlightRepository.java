package com.cognizant.flightmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.flightmanagement.model.Flight;
@Repository
public interface IFlightRepository  extends JpaRepository<Flight, String>{
	

}
