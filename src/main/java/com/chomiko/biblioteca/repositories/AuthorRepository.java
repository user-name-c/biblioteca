package com.chomiko.biblioteca.repositories;

import com.chomiko.biblioteca.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
