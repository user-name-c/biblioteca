package com.chomiko.biblioteca.controllers;

import com.chomiko.biblioteca.models.Language;
import com.chomiko.biblioteca.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping
    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Language> addLanguage(@RequestBody Language language) {
        if (languageRepository.findByName(language.getName()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        Language savedLanguage = languageRepository.save(language);
        return ResponseEntity.ok(savedLanguage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable Long id) {
        if (languageRepository.existsById(id)) {
            languageRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
