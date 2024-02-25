package com.example.assessment_backend_developer_xsis.controller;

import com.example.assessment_backend_developer_xsis.model.BaseResponse;
import com.example.assessment_backend_developer_xsis.model.dto.MovieDto;
import com.example.assessment_backend_developer_xsis.model.entity.Movie;
import com.example.assessment_backend_developer_xsis.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
@Slf4j
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private ModelMapper mapperFacade;


    @PostMapping()
    public BaseResponse createMovie(@RequestBody MovieDto movieDto) {
        try {
            Movie movie = mapperFacade.map(movieDto, Movie.class);
            Movie createdMovie = movieService.saveMovie(movie);
            return new BaseResponse(true, "Movie Success Created", createdMovie);
        } catch (Exception e) {
            log.info("Error occurred while creating movie {}", e.getMessage());
            return new BaseResponse(false, e.getMessage(), null);
        }
    }

    @PostMapping("save-all")
    public BaseResponse createMovies(@RequestBody List<MovieDto> movieDtos) {
        try {
            List<Movie> movies = new ArrayList<>();
            for (MovieDto movieDto : movieDtos) {
                Movie movie = mapperFacade.map(movieDto, Movie.class);
                movies.add(movie);
            }
            List<Movie> createdMovies = movieService.saveAllMovie(movies);
            return new BaseResponse(true, "Movies Success Created", createdMovies);
        } catch (Exception e) {
            log.info("Error occurred while creating movies {}", e.getMessage());
            return new BaseResponse(false, e.getMessage(), null);
        }
    }

    @GetMapping()
    public BaseResponse getAllMovies() {
        try {
            List<Movie> getAllMovies = movieService.getAllMovies();
            return new BaseResponse(true, "Movie Found", getAllMovies);
        } catch (Exception e) {
            log.info("Error occurred while fetching all movies {}", e.getMessage());
            return new BaseResponse(false, e.getMessage(), null);
        }
    }

    @GetMapping("/{id}")
    public BaseResponse getMovieById(@PathVariable int id) {
        try {
            Movie getMovieById = movieService.getMovieById(id);
            if (getMovieById == null) {
                throw new Exception("Error occurred while fetching movie by id: " + id);
            }
            return new BaseResponse(true, "Movie found with id: " + id + " found", getMovieById);
        } catch (Exception e) {
            log.info("Error occurred while fetching movie by id: " + id + " \n {} ", e.getMessage());
            return new BaseResponse(false, e.getMessage(), null);
        }
    }

    @PatchMapping("/{id}")
    public BaseResponse updateMovie(@PathVariable int id, @RequestBody MovieDto movieDto) {
        try {
            Movie movie = mapperFacade.map(movieDto, Movie.class);
            Movie updatedMovie = movieService.updateMovie(id, movie);
            if (updatedMovie == null) {
                throw new Exception("Movie with id: " + id + " not found");
            }
            return new BaseResponse(true, "Movie updated successfully with id: " + id, updatedMovie);
        } catch (Exception e) {
            log.info("Error occurred while updating movie with id: " + id + " \n {} ", e.getMessage());
            return new BaseResponse(false, e.getMessage(), null);
        }
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteMovie(@PathVariable int id) {
        try {
            boolean deletedMovie = movieService.deleteMovie(id);
            if (!deletedMovie) {
                throw new Exception("Error occurred while deleting movie with id: " + id);
            }
            return new BaseResponse(true, "Movie deleted successfully with id: " + id, deletedMovie);
        } catch (Exception e) {
            log.info("Error occurred while deleting movie with id: " + id + " \n {} ", e.getMessage());
            return new BaseResponse(false, e.getMessage(), null);
        }
    }

}
