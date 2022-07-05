package com.evaluacion.parteuno.javaspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaluacion.parteuno.javaspring.error.ResourceNotFoundException;
import com.evaluacion.parteuno.javaspring.model.Country;
import com.evaluacion.parteuno.javaspring.repository.CountryRepository;
/**
 * 
 * @author emma.romero
 *
 */
@Service
@Transactional
public class CountryServiceImpl implements CountryService{
	 @Autowired
	    private CountryRepository countryRepository;

	    @Override
	    public Country createCountry(Country country) {
	        return countryRepository.save(country);
	    }

	    @Override
	    public Country updateCountry(Country country) {
	        Optional<Country> countryDb = this.countryRepository.findById(country.getId_country());

	        if (countryDb.isPresent()){
	            Country countryUpdate = countryDb.get();
	            countryUpdate.setId_country(country.getId_country());
	            countryUpdate.setName(country.getName());
	            countryUpdate.setCode(country.getCode());
	            countryRepository.save(countryUpdate);
	            return countryUpdate;
	        }else {
	            throw new ResourceNotFoundException("Record not found with id : " + country.getId_country());
	        }
	    }

	    @Override
	    public List<Country> getAllCountrys() {
	        return this.countryRepository.findAll();
	    }

	    @Override
	    public Country getCountryById(long countryId) {
	        Optional<Country> countryDB = this.countryRepository.findById(countryId);

	        if (countryDB.isPresent()) {
	            return countryDB.get();
	        } else {
	            throw new ResourceNotFoundException("Record not found with id : " + countryId);
	        }
	    }

	    @Override
	    public void deleteCountry(long countryId) {
	        Optional<Country> countryDB = this.countryRepository.findById(countryId);

	        if (countryDB.isPresent()) {
	            this.countryRepository.delete(countryDB.get());
	        } else {
	            throw new ResourceNotFoundException("Record not found with id: " + countryId);
	        }
	    }
}
