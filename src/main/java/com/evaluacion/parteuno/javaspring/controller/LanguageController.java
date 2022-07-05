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
import com.evaluacion.parteuno.javaspring.model.Language;
import com.evaluacion.parteuno.javaspring.service.LanguageService;
/**
 * 
 * @author emma.romero
 *
 */
@RestController
@RequestMapping("/Language")
public class LanguageController {
    @Autowired
    private LanguageService Languageservice;

    @GetMapping("/getLanguage")
    public ResponseEntity<?> getAllLanguage(){
        List<Language> lista = Languageservice.getAllLanguages();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Not Found Data Language"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(Languageservice.getAllLanguages());
    }

    @GetMapping("/getLanguage/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable long id) {
        return ResponseEntity.ok().body(this.Languageservice.getLanguageById(id));
    }

    @PostMapping("/createLanguage")
    public ResponseEntity<Language> createLanguage(@RequestBody Language Language) {
        return ResponseEntity.ok().body(this.Languageservice.createLanguage(Language));
    }


    @PutMapping("/updateLanguage/{id}")
    public ResponseEntity<Language> updateLanguage(@PathVariable long id, @RequestBody Language Language){
        Language.setId_language(id);
        return ResponseEntity.ok().body(this.Languageservice.updateLanguage(Language));
    }

    @DeleteMapping("/deleteLanguage/{id}")
    public HttpStatus deleteLanguage(@PathVariable long id){
        this.Languageservice.deleteLanguage(id);
        return HttpStatus.OK;
    }
}