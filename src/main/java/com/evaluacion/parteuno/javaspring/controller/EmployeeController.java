package com.evaluacion.parteuno.javaspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.parteuno.javaspring.error.Mensaje;
import com.evaluacion.parteuno.javaspring.model.Employee;
import com.evaluacion.parteuno.javaspring.service.EmployeeService;
/**
 * 
 * @author emma.romero
 *
 */
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/Employee/getEmployee")
    public ResponseEntity<?> getAllEmployee(){
        List<Employee> lista = employeeService.getAllEmployee();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Not Found Data Employee"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(employeeService.getAllEmployee());
    }

    @GetMapping("/Employee/getEmployee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        return ResponseEntity.ok().body(this.employeeService.getEmployeeById(id));
    }

    @PostMapping("/Employee/createEmployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok().body(this.employeeService.createEmployee(employee));
    }
    
    @PostMapping("/apiv1/clientes/add")
    public ResponseEntity<Employee> insertEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok().body(this.employeeService.createEmployee(employee));
    }


    @PutMapping("/Employee/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
        employee.setId_employee(id);
        return ResponseEntity.ok().body(this.employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/Employee/deleteEmployee/{id}")
    public HttpStatus deleteEmployee(@PathVariable long id){
        this.employeeService.deleteEmployee(id);
        return HttpStatus.OK;
    }
}