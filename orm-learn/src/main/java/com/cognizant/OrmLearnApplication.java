package com.cognizant;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.model.Country;
import com.cognizant.service.CountryNotFoundException;
import com.cognizant.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {
	
	private static CountryService countryService;

	@Autowired
	public void setCountryService(CountryService countryService) {
		OrmLearnApplication.countryService = countryService;
	}

	static Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	public static void main(String[] args){
     	SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Inside main");
	}
	

	private void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}
	private void testGetById(String code) throws CountryNotFoundException {
		LOGGER.info("Start");
		Country findCountryByCode = countryService.findCountryByCode(code);
		LOGGER.debug("countries={}", findCountryByCode);
		LOGGER.info("End");
	}
	
	private void testAdd()
	{
		LOGGER.info("Start");
		Country country = new Country();
		country.setCode("AA");
		country.setName("Aman");
		countryService.addCountry(country);
		LOGGER.info("End");
	}
	private void testUpdateById(String code,String name) throws CountryNotFoundException {
		LOGGER.info("Start");
		countryService.UpdateByCode(code, name);
		LOGGER.info("End");
	}
	private void testdelete(String code)
	{
		LOGGER.info("Start");
		countryService.DeleteByCode(code);
		LOGGER.info("End");
	}

	@Override
	public void run(String... args) throws Exception{
			testGetAllCountries();
			testGetById("IN");
			testAdd();
			testUpdateById("AA","AmanAGarwal");
			testdelete("AA");
	}
}
