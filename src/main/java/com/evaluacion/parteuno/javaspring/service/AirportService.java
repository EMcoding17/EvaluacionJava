package com.evaluacion.parteuno.javaspring.service;

import java.util.List;

import com.evaluacion.parteuno.javaspring.model.Airport;
/**
 * 
 * @author emma.romero
 *
 */
public interface AirportService {
	Airport createAirport(Airport airport);

    Airport updateAirport(Airport airport);

    List<Airport> getAllAirports();

    Airport getAirportById(long airportId);

    void deleteAirport(long id);
}
