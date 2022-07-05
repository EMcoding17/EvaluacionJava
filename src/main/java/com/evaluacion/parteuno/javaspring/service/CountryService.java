package com.evaluacion.parteuno.javaspring.service;

import java.util.List;

import com.evaluacion.parteuno.javaspring.model.Country;
/**
 * 
 * @author emma.romero
 *
 */
public interface CountryService {

    Country createCountry(Country country);

    Country updateCountry(Country country);

    List<Country> getAllCountrys();

    Country getCountryById(long countryId);

    void deleteCountry(long id);
}
