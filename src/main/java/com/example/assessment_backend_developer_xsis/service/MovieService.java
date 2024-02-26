package com.example.assessment_backend_developer_xsis.service;

import com.example.assessment_backend_developer_xsis.model.entity.Movie;
import com.example.assessment_backend_developer_xsis.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie getMovieById(Integer id) {
        return movieRepository.findById(id).orElse(null);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> saveAllMovie(List<Movie> movie) {
        return movieRepository.saveAll(movie);
    }

    public Movie updateMovie(Integer id, Movie movie) {
        Movie getMovieById = getMovieById(id);
        if (getMovieById != null) {
            getMovieById.setTitle(movie.getTitle());
            getMovieById.setDescription(movie.getDescription());
            getMovieById.setRating(movie.getRating());
            getMovieById.setImage(movie.getImage());
            return movieRepository.save(getMovieById);
        } else {
            return null;
        }
    }

    public boolean deleteMovie(Integer id) {
        Movie movie = getMovieById(id);
        if (movie != null) {
            movieRepository.delete(movie);
            return true;
        }
        return false;
    }

}
