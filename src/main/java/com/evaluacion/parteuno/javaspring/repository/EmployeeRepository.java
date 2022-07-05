package com.evaluacion.parteuno.javaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evaluacion.parteuno.javaspring.model.Employee;
/**
 * 
 * @author emma.romero
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
