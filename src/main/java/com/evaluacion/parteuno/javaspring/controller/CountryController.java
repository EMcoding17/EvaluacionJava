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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.parteuno.javaspring.error.Mensaje;
import com.evaluacion.parteuno.javaspring.model.Country;
import com.evaluacion.parteuno.javaspring.service.CountryService;
/**
 * 
 * @author emma.romero
 *
 */

@RestController
@RequestMapping("/Country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/getCountry")
    public ResponseEntity<?> getAllCountry(){
        List<Country> lista = countryService.getAllCountrys();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Not Found Data Country"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(countryService.getAllCountrys());
    }

    @GetMapping("/getCountry/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable long id) {
        return ResponseEntity.ok().body(this.countryService.getCountryById(id));
    }

    @PostMapping("/createCountry")
    public ResponseEntity<Country> createCountry(@RequestBody Country Country) {
        return ResponseEntity.ok().body(this.countryService.createCountry(Country));
    }


    @PutMapping("/updateCountry/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable long id, @RequestBody Country Country){
        Country.setId_country(id);
        return ResponseEntity.ok().body(this.countryService.updateCountry(Country));
    }

    @DeleteMapping("/deleteCountry/{id}")
    public HttpStatus deleteCountry(@PathVariable long id){
        this.countryService.deleteCountry(id);
        return HttpStatus.OK;
    }
}