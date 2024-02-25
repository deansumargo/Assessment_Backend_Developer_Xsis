package com.example.assessment_backend_developer_xsis;

import com.example.assessment_backend_developer_xsis.controller.MovieController;
import com.example.assessment_backend_developer_xsis.model.BaseResponse;
import com.example.assessment_backend_developer_xsis.model.dto.MovieDto;
import com.example.assessment_backend_developer_xsis.model.entity.Movie;
import com.example.assessment_backend_developer_xsis.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MovieControllerTest {

    @Mock
    private MovieService movieService;

    @Mock
    private ModelMapper mapperFacade;

    @InjectMocks
    private MovieController movieController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateMovie() {
        MovieDto movieDto = new MovieDto("Title", "Description", 8.0f, "image.jpg");
        Movie movie = new Movie();
        movie.setTitle("Title");
        movie.setDescription("Description");
        movie.setRating(8.0f);
        movie.setImage("image.jpg");

        when(mapperFacade.map(movieDto, Movie.class)).thenReturn(movie);
        when(movieService.saveMovie(movie)).thenReturn(movie);

        BaseResponse response = movieController.createMovie(movieDto);

        assertEquals(true, response.getSuccess());
        assertEquals("Movie Success Created", response.getMessage());
        assertEquals(movie, response.getData());
    }

    @Test
    void testCreateMovies() {
        List<MovieDto> movieDtos = new ArrayList<>();
        movieDtos.add(new MovieDto("Title1", "Description1", 8.0f, "image1.jpg"));
        movieDtos.add(new MovieDto("Title2", "Description2", 9.0f, "image2.jpg"));

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Title1", "Description1", 8.0f, "image1.jpg", new Date(), new Date()));
        movies.add(new Movie(2, "Title2", "Description2", 9.0f, "image2.jpg", new Date(), new Date()));

        when(mapperFacade.map(movieDtos.get(0), Movie.class)).thenReturn(movies.get(0));
        when(mapperFacade.map(movieDtos.get(1), Movie.class)).thenReturn(movies.get(1));


        when(movieService.saveAllMovie(movies)).thenReturn(movies);

        BaseResponse response = movieController.createMovies(movieDtos);

        assertEquals(true, response.getSuccess());
        assertEquals("Movies Success Created", response.getMessage());
        assertEquals(movies, response.getData());
    }

    @Test
    void testGetAllMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Title1", "Description1", 8.0f, "image1.jpg", new Date(), new Date()));
        movies.add(new Movie(2, "Title2", "Description2", 9.0f, "image2.jpg", new Date(), new Date()));

        when(movieService.getAllMovies()).thenReturn(movies);

        BaseResponse response = movieController.getAllMovies();

        assertEquals(true, response.getSuccess());
        assertEquals("Movie Found", response.getMessage());
        assertEquals(movies, response.getData());
    }

    @Test
    void testGetMovieById() {
        int id = 1;
        Movie movie = new Movie(1, "Title1", "Description1", 8.0f, "image1.jpg", new Date(), new Date());

        when(movieService.getMovieById(id)).thenReturn(movie);

        BaseResponse response = movieController.getMovieById(id);

        assertEquals(true, response.getSuccess());
        assertEquals("Movie found with id: " + id + " found", response.getMessage());
        assertEquals(movie, response.getData());
    }

    @Test
    void testGetMovieByIdNull() {
        int id = 1;
        when(movieService.getMovieById(id)).thenReturn(null);

        BaseResponse response = movieController.getMovieById(id);

        assertEquals(false, response.getSuccess());
        assertEquals("Error occurred while fetching movie by id: " + id, response.getMessage());
        assertEquals(null, response.getData());
    }

    @Test
    void testUpdateMovie() {
        int id = 1;
        MovieDto movieDto = new MovieDto("Title1", "Description1", 8.0f, "image1.jpg");
        Movie movie = new Movie(1, "Title1", "Description1", 8.0f, "image1.jpg", new Date(), new Date());
        when(movieService.updateMovie(id, mapperFacade.map(movieDto, Movie.class))).thenReturn(movie);
        BaseResponse response = movieController.updateMovie(id, movieDto);
        assertEquals(true, response.getSuccess());
        assertEquals("Movie updated successfully with id: " + id, response.getMessage());
        assertEquals(movie, response.getData());
    }

    @Test
    void testUpdateMovieNull() {
        int id = 1;
        MovieDto movieDto = new MovieDto();
        when(movieService.updateMovie(id, mapperFacade.map(movieDto, Movie.class))).thenReturn(null);
        BaseResponse response = movieController.updateMovie(id, movieDto);
        assertEquals(false, response.getSuccess());
        assertEquals("Movie with id: " + id + " not found", response.getMessage());
        assertEquals(null, response.getData());
    }

    @Test
    void testDeleteMovie() {
        int id = 1;
        when(movieService.deleteMovie(id)).thenReturn(true);

        BaseResponse response = movieController.deleteMovie(id);

        assertEquals(true, response.getSuccess());
        assertEquals("Movie deleted successfully with id: " + id, response.getMessage());
        assertEquals(true, response.getData());
    }

    @Test
    void deleteMovieFalse() {
        int id = 1;
        when(movieService.deleteMovie(id)).thenReturn(false);
        BaseResponse response = movieController.deleteMovie(id);
        assertEquals(false, response.getSuccess());
        assertEquals("Error occurred while deleting movie with id: " + id, response.getMessage());
        assertEquals(null, response.getData());
    }
}

