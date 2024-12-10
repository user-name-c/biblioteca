package com.chomiko.biblioteca.controllers;

import com.chomiko.biblioteca.models.Publisher;
import com.chomiko.biblioteca.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Publisher> addPublisher(@RequestBody Publisher publisher) {
        if (publisherRepository.findByName(publisher.getName()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        Publisher savedPublisher = publisherRepository.save(publisher);
        return ResponseEntity.ok(savedPublisher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable Long id) {
        if (publisherRepository.existsById(id)) {
            publisherRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
