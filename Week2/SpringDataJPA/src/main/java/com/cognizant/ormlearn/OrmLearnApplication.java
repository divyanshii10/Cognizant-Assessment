package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        LOGGER.info("Inside main");

        // Seed data for H2 DB
        seedData();

        testGetAllCountries();
        testAddCountry();
        testFindCountryByCode();
        testUpdateCountry();
        testDeleteCountry();
        testSearchCountryByName();
    }

    private static void seedData() {
        countryService.addCountry(new Country("IN", "India"));
        countryService.addCountry(new Country("US", "United States of America"));
        countryService.addCountry(new Country("JP", "Japan"));
        countryService.addCountry(new Country("AU", "Australia"));
        LOGGER.info("Seeded initial countries");
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End testGetAllCountries");
    }

    private static void testAddCountry() {
        LOGGER.info("Start testAddCountry");
        Country newCountry = new Country("BR", "Brazil");
        countryService.addCountry(newCountry);
        LOGGER.debug("Added country: {}", newCountry);
        LOGGER.info("End testAddCountry");
    }

    private static void testFindCountryByCode() {
        LOGGER.info("Start testFindCountryByCode");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country found: {}", country);
        } catch (Exception e) {
            LOGGER.error("Error: ", e);
        }
        LOGGER.info("End testFindCountryByCode");
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start testUpdateCountry");
        try {
            countryService.updateCountry("US", "United States");
            Country updatedCountry = countryService.findCountryByCode("US");
            LOGGER.debug("Updated country: {}", updatedCountry);
        } catch (Exception e) {
            LOGGER.error("Error: ", e);
        }
        LOGGER.info("End testUpdateCountry");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start testDeleteCountry");
        countryService.deleteCountry("BR");
        LOGGER.debug("Deleted country with code BR");
        LOGGER.info("End testDeleteCountry");
    }

    private static void testSearchCountryByName() {
        LOGGER.info("Start testSearchCountryByName");
        List<Country> countries = countryService.searchCountryByName("ia");
        LOGGER.debug("Countries containing 'ia': {}", countries);
        LOGGER.info("End testSearchCountryByName");
    }
}
