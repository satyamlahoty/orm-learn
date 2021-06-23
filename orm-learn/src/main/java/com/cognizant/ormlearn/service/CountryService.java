package com.cognizant.ormlearn.service;

import java.util.List;

import com.cognizant.ormlearn.custom_exception.CountryNotFoundException;
import com.cognizant.ormlearn.model.Country;

public interface CountryService {

	public List<Country> getAllCountries();

	public Country findCountryByCode(String countryCode) throws CountryNotFoundException;

	public void addCountry(Country country);

//	public void updateCountry(String code, String name);

	void deleteCountry(String code);
	
	List<Country> findCountryByCharacter(String name);

	List<Country> findCountryUsingSingleCharacter(String name);

	
}