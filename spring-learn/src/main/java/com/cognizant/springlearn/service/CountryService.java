package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
	public Country getCountryIndia() {
		Country india=(Country)context.getBean("country");
		return india;
	}
	@SuppressWarnings("unchecked")
	public List<Country> getAllCountries() {
		List<Country> countries = (List<Country>) context.getBean("countryList");
		return countries;
	}
	public Country getCountry(String code) throws CountryNotFoundException {
		@SuppressWarnings("unchecked")
		List<Country> countries = (List<Country>) context.getBean("countryList");
		for(Country con:countries) {
			if(con.getCode().equalsIgnoreCase(code)) {
				return con;
			}
		}
			throw new CountryNotFoundException();
	}
	public Country addCountry(Country country){
		@SuppressWarnings("unchecked")
		List<Country> countries = (List<Country>) context.getBean("countryList");
		if(countries.add(country)) {
			return country;
		}
		return null;
	}
}
