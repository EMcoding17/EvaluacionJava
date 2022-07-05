package com.evaluacion.parteuno.javaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evaluacion.parteuno.javaspring.model.Country;
/**
 * 
 * @author emma.romero
 *
 */

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

}
