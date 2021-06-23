package com.cognizant.flightmanagement.model;



import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity

public class Flight {
@Id	
private String id;
private  String flightType;

@OneToMany
private List<Passenger> passengers;



public Flight() {
	super();
	// TODO Auto-generated constructor stub
}


public Flight(String id, String flightType) {
	
	this.id = id;
	this.flightType = flightType;
	
}


public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public String getFlightType() {
	return flightType;
}


public void setFlightType(String flightType) {
	this.flightType = flightType;
}


public List<Passenger> getPassengers() {
	return passengers;
}


public void setPassengers(List<Passenger> passengers) {
	this.passengers = passengers;
}


public boolean addPassenger(Passenger p) {
	return passengers.add(p);
}


public boolean removePassenger(Passenger p) {
	return passengers.remove(p);
	
}
}
