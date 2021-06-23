package com.cognizant.flightmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.flightmanagement.model.Passenger;
@Repository
public interface IPassengerRepository extends JpaRepository<Passenger, String> {
	

}
