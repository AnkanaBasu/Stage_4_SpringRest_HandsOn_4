 package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@SuppressWarnings("resource")
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
		displayCountry();
		displayCountries();
	}
	public static void displayDate() throws ParseException {
		LOGGER.info("Start method displayDate");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml"); 
		SimpleDateFormat format=context.getBean("dateFormat", SimpleDateFormat.class);
		Date date=format.parse("31/12/2018");
		LOGGER.debug("Date : {}",date); 
		LOGGER.info("End method displayDate");
	}
	public static void displayCountry() {
		LOGGER.info("Start method displayCountry");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country=(Country)context.getBean("country", Country.class);
		Country anotherCountry=(Country)context.getBean("country",Country.class);
		LOGGER.debug("Country : {}", country.toString());
		LOGGER.debug("Country : {}", anotherCountry.toString());
		LOGGER.info("End method displayCountry");
	}
	@SuppressWarnings("unchecked" )
	public static void displayCountries() {
		LOGGER.info("Start method displayCountries");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countries=(ArrayList<Country>)context.getBean("countryList");
		LOGGER.debug("Country List: {}", countries);
		LOGGER.info("End method displayCountries");
	}

}
