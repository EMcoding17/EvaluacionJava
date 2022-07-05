package com.evaluacion.parteuno.javaspring.service;

import java.util.List;

import com.evaluacion.parteuno.javaspring.model.Language;
/**
 * 
 * @author emma.romero
 *
 */
public interface LanguageService {

    Language createLanguage(Language languaje);

    Language updateLanguage(Language languaje);

    List<Language> getAllLanguages();

    Language getLanguageById(long languajeId);

    void deleteLanguage(long id);
}
