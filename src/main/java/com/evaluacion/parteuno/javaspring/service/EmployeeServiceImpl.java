package com.evaluacion.parteuno.javaspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaluacion.parteuno.javaspring.error.ResourceNotFoundException;
import com.evaluacion.parteuno.javaspring.model.Employee;
import com.evaluacion.parteuno.javaspring.repository.EmployeeRepository;
/**
 * 
 * @author emma.romero
 *
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> employeeDb = this.employeeRepository.findById(employee.getId_employee());

        if (employeeDb.isPresent()){
            Employee employeeUpdate = employeeDb.get();
            employeeUpdate.setId_employee(0);
            employeeUpdate.setSurname(employee.getSurname());
            employeeUpdate.setFirstname(null);
            employeeRepository.save(employeeUpdate);
            return employeeUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + employee.getId_employee());
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long employeeId) {
        Optional<Employee> employeeDB = this.employeeRepository.findById(employeeId);

        if (employeeDB.isPresent()) {
            return employeeDB.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + employeeId);
        }
    }

    @Override
    public void deleteEmployee(long employeeId) {
        Optional<Employee> employeeDB = this.employeeRepository.findById(employeeId);

        if (employeeDB.isPresent()) {
            this.employeeRepository.delete(employeeDB.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + employeeId);
        }
    }
}