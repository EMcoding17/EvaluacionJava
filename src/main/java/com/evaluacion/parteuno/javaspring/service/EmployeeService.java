package com.evaluacion.parteuno.javaspring.service;

import java.util.List;

import com.evaluacion.parteuno.javaspring.model.Employee;
/**
 * 
 * @author emma.romero
 *
 */
public interface EmployeeService {
	
	Employee createEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	List<Employee> getAllEmployee();
    Employee getEmployeeById(long employeeId);
    void deleteEmployee(long id);
}
