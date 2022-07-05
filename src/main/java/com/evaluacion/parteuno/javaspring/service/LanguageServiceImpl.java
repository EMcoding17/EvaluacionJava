package com.evaluacion.parteuno.javaspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaluacion.parteuno.javaspring.error.ResourceNotFoundException;
import com.evaluacion.parteuno.javaspring.model.Language;
import com.evaluacion.parteuno.javaspring.repository.LanguageRepository;
/**
 * 
 * @author emma.romero
 *
 */
@Service
@Transactional
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public Language createLanguage(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public Language updateLanguage(Language language) {
        Optional<Language> languageDb = this.languageRepository.findById(language.getId_language());

        if (languageDb.isPresent()){
            Language languageUpdate = languageDb.get();
            languageUpdate.setId_language(language.getId_language());
            languageUpdate.setName(language.getName());
            languageUpdate.setCode(language.getCode());
            languageRepository.save(languageUpdate);
            return languageUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + language.getId_language());
        }
    }

    @Override
    public List<Language> getAllLanguages() {
        return this.languageRepository.findAll();
    }

    @Override
    public Language getLanguageById(long languageId) {
        Optional<Language> languageDB = this.languageRepository.findById(languageId);

        if (languageDB.isPresent()) {
            return languageDB.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + languageId);
        }
    }

    @Override
    public void deleteLanguage(long languageId) {
        Optional<Language> languageDB = this.languageRepository.findById(languageId);

        if (languageDB.isPresent()) {
            this.languageRepository.delete(languageDB.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + languageId);
        }
    }
}