package com.example.movies.persistence.repository;

import com.example.movies.persistence.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {

}
