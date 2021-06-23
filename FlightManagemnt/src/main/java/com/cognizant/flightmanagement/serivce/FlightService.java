package com.cognizant.flightmanagement.serivce;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.flightmanagement.model.Flight;
import com.cognizant.flightmanagement.model.Passenger;
import com.cognizant.flightmanagement.repository.IFlightRepository;

@Service
public class FlightService { 
	
	@Autowired
	private IFlightRepository flightrepo; 
	
	public  static final int maxFlightPassenger =5;
	
	public String createFlight(Flight f) {
		flightrepo.saveAndFlush(f);
		return "Flight Created";
		
	} 
	
	

     public  List<Flight>  getAllFlight(){
		return flightrepo.findAll();
		
	}
	
	
	
	public Flight getFlightById(String id) {
		Optional<Flight>  result = flightrepo.findById(id);
		if(result.isPresent())
			return  result.get(); 
		
		else 
			System.out.println("Flight not avialable by Id");
			return  null;
		
		
	}
	
	public  String removeFlight(String id) {
		Optional<Flight> op = flightrepo.findById(id);
		if(op.isPresent()) {
		 flightrepo.delete(op.get());
		 return "flight deleted";
		}
		else {
			 return "flight not available";
		}
	}
	
	public  String updateFlight(Flight s) { 
		/*
		 * Optional<Flight> op = repo.findById(s.getId()); if(op.isPresent()) { Flight
		 * stu = op.get(); stu.setMarks(s.getMarks()); repo.saveAndFlush(stu); return
		 * "Flight UPdated"; } else { return "Flight not found"; }
		 */
		Optional<Flight> op = flightrepo.findById(s.getId());
		if(op.isPresent()) {
		 flightrepo.saveAndFlush(s);
		 System.out.println("jy"+op.get());
		 return "Flight updated";
		}
		else {
			 return "Flight not available";
		}
		
	}
		
		public  String addPassenger(Flight f, Passenger p) {
			
		if(	f.getFlightType().equalsIgnoreCase("Economy")) {
			f.addPassenger(p);
			updateFlight(f);
			return "passenger added";
			
		}
		
		else {
			if(p.isVip()) {
				f.addPassenger(p);
				updateFlight(f);
				return "passenger added";	
				
			}
			else {
				
				return null;
			}
		}
			
		}
		
		public  String removePassenger(Flight f, Passenger p) {
			
		
		
	
			if(!p.isVip()) {
				f.removePassenger(p);
				updateFlight(f);
				return "passenger Removed";	
				
			}
			else {
				
				return null;
			}
		
			
		} 
		
		public List<Passenger>  getAllPassenger(String id){
			Flight f = getFlightById(id);
		return	f.getPassengers();
		}
		
			
	
}
