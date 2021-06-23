package com.cognizant.ormlearn.custom_exception;

public class CountryNotFoundException extends Exception {
	
	public CountryNotFoundException(String s){
		super(s);
	}
}
