package com.cognizant.flightmanagement.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.flightmanagement.model.Flight;
import com.cognizant.flightmanagement.model.Passenger;
import com.cognizant.flightmanagement.serivce.FlightService;
import com.cognizant.flightmanagement.serivce.PassengerService;

@Controller
public class FlightController {  
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private PassengerService passengerService;
	
	
	@RequestMapping("/")
	public String viewHome() {
		return "index";
		
		
		
	}
	
	@RequestMapping("/viewallflights")
	public String viewAllFlights(Model map) {
		System.out.println("in view all flight");
		List<Flight> list = flightService.getAllFlight();
		map.addAttribute("flightList",list);
		
		return "viewAllFlights";
		
			
	}
	
	@RequestMapping("/viewallpassengers")
	public String viewAllPassenger(Model map) {
		System.out.println("in view all passenger");
		List<Passenger> list = passengerService.getAllPassenger();
		map.addAttribute("passengerList",list);
		return "viewAllPassenger";
		
			
	}
	
	
	@RequestMapping(value="/addnewflight"  , method=RequestMethod.GET)
	public String viewAddNewFlight(@ModelAttribute Flight flight) {
		return "newflight";
		
		
		
	} 
	
	@RequestMapping(value="/addnewpassenger"  , method=RequestMethod.GET)
	public String viewAddNewPassenger(@ModelAttribute Passenger passenger) {
		return "newpassenger";
		
		
		
	}
	
	@RequestMapping(value="/addflight", method=RequestMethod.POST)
	public String saveFlight(Flight f) {
		
		System.out.println("hello in create");
		System.out.println(flightService.createFlight(f));
		return "redirect:/viewallflights";
	}
	
	@RequestMapping(value="/addpassenger", method=RequestMethod.POST)
	public String savePassenger(Passenger p) {
		
		System.out.println("hello in create");
		System.out.println(passengerService.createPassenger(p));
		return "redirect:/viewallpassengers";
	}
	
	@ModelAttribute("type")
	public List<String> flightType() {
		List<String> type=new ArrayList<String>();
		type.add("Economy");
		type.add("Busniess");
		
		return type;
	
	}
	@ModelAttribute("isVip")
	public List<String> PassengerType() {
		List<String> type=new ArrayList<String>();
		type.add("Yes");
		type.add("No");
		
		return type;
	
	}  
	@RequestMapping(value = "/addpassengertoflight",method = RequestMethod.GET)
	public String addPassengerToFlight(Model map,String id) {
		List<Passenger> p = passengerService.getAllPassenger();
		map.addAttribute("passengerList",p);
		Flight f= flightService.getFlightById(id);
		map.addAttribute("flight",f);
		return "addpassengertoflight"; 
		
	}
	
	@RequestMapping(value = "/removepassengertoflight",method = RequestMethod.GET)
	public String removePassengerToFlight(Model map,String id) {
		List<Passenger> p = flightService.getAllPassenger(id);
		System.out.println("k"+p);
		if(p.size()==0) {
			map.addAttribute("result","No Passneger in this Flight");
			return "error";
		}
			
		else {
			map.addAttribute("passengerList",p);
		Flight f= flightService.getFlightById(id);
		map.addAttribute("flight",f);
		return "removepassengertoflight"; 
		}
		
	}
	
	@RequestMapping(value = "/added",method = RequestMethod.POST)
	public String addedPassengerToFlight(String f_id, String p,Model m) {
		System.out.println("in function");
		System.out.println(f_id+p);
		Flight f= flightService.getFlightById(f_id);
		Passenger passenger =passengerService.getPassengerById(p); 
	String result=	flightService.addPassenger(f, passenger);
	if(result==null) {
		m.addAttribute("result", "Non - Vip Paasegers cannot be added to Business class");
		return "error";
	}
	else {
		
		return "redirect:/viewallflights";
	}
	
	
		
	}
	
	@RequestMapping(value = "/removed",method = RequestMethod.POST)
	public String removedPassengerToFlight(String f_id, String p,Model m) {
		System.out.println("in function");
		System.out.println(f_id+p);
		Flight f= flightService.getFlightById(f_id);
		Passenger passenger =passengerService.getPassengerById(p); 
	String result=	flightService.removePassenger(f, passenger);
	if(result==null) {
		m.addAttribute("result", "Non - Vip Paasegers cannot be removed");
		return "error";
	}
	else {
		
		return "redirect:/viewallflights";
	}
	
	
		
	}
}
