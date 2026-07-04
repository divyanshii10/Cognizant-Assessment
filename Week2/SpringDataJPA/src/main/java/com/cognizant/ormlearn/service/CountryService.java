package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Country findCountryByCode(String countryCode) throws Exception {
        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new Exception("Country not found");
        }
        return result.get();
    }

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void updateCountry(String countryCode, String name) throws Exception {
        Country country = findCountryByCode(countryCode);
        country.setName(name);
        countryRepository.save(country);
    }

    @Transactional
    public void deleteCountry(String countryCode) {
        countryRepository.deleteById(countryCode);
    }

    @Transactional(readOnly = true)
    public List<Country> searchCountryByName(String name) {
        return countryRepository.findByNameContainingOrderByNameAsc(name);
    }
}
