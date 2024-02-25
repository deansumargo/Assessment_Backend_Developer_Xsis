package com.example.assessment_backend_developer_xsis.repository;

import com.example.assessment_backend_developer_xsis.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
