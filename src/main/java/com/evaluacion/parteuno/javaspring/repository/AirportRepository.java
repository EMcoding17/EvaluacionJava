package com.evaluacion.parteuno.javaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evaluacion.parteuno.javaspring.model.Airport;
/**
 * 
 * @author emma.romero
 *
 */
@Repository
public interface AirportRepository extends JpaRepository<Airport, Long>{

}
