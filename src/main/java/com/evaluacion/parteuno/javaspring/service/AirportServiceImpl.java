package com.evaluacion.parteuno.javaspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaluacion.parteuno.javaspring.error.ResourceNotFoundException;
import com.evaluacion.parteuno.javaspring.model.Airport;
import com.evaluacion.parteuno.javaspring.repository.AirportRepository;
/**
 * 
 * @author emma.romero
 *
 */
@Service
@Transactional
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

	@Override
	public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
	}

	@Override
	public Airport updateAirport(Airport airport) {
        Optional<Airport> airportDb = this.airportRepository.findById(airport.getId_airport());

        if (airportDb.isPresent()){
            Airport airportUpdate = airportDb.get();
            airportUpdate.setId_airport(airport.getId_airport());
            airportUpdate.setName(airport.getName());
            airportRepository.save(airportUpdate);
            return airportUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + airport.getId_airport());
        }
	}

	@Override
	public List<Airport> getAllAirports() {
        return this.airportRepository.findAll();
	}

	@Override
	public Airport getAirportById(long airportId) {
        Optional<Airport> airportDB = this.airportRepository.findById(airportId);

        if (airportDB.isPresent()) {
            return airportDB.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + airportId);
        }
	}

	@Override
	public void deleteAirport(long id) {
        Optional<Airport> airportDB = this.airportRepository.findById(id);

        if (airportDB.isPresent()) {
            this.airportRepository.delete(airportDB.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + id);
        }
		
	}

}
