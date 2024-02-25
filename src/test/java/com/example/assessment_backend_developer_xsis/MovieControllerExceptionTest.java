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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MovieControllerExceptionTest {

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
    void testCreateMovie_Exception() {
        MovieDto movieDto = new MovieDto("Title1", "Description1", 8.0f, "image1.jpg");
        when(mapperFacade.map(movieDto, Movie.class)).thenThrow(new RuntimeException("Mapping failed"));

        BaseResponse response = movieController.createMovie(movieDto);

        assertFalse(response.getSuccess());
        assertEquals("Mapping failed", response.getMessage());
        assertNull(response.getData());
    }

    @Test
    void testCreateMovies_Exception() {
        List<MovieDto> movieDtos = new ArrayList<>();
        movieDtos.add(new MovieDto("Title1", "Description1", 8.0f, "image1.jpg"));
        movieDtos.add(new MovieDto("Title2", "Description2", 9.0f, "image2.jpg"));

        when(mapperFacade.map(any(MovieDto.class), eq(Movie.class))).thenThrow(new RuntimeException("Mapping failed"));

        BaseResponse response = movieController.createMovies(movieDtos);

        assertFalse(response.getSuccess());
        assertEquals("Mapping failed", response.getMessage());
        assertNull(response.getData());

        verify(movieService, never()).saveAllMovie(any());
    }

    @Test
    void testGetAllMovies_Exception() {
        when(movieService.getAllMovies()).thenThrow(new RuntimeException("Database connection failed"));

        BaseResponse response = movieController.getAllMovies();

        assertFalse(response.getSuccess());
        assertEquals("Database connection failed", response.getMessage());
        assertNull(response.getData());
    }

    @Test
    void testGetMovieById_Exception() {
        int id = 1;
        when(movieService.getMovieById(id)).thenThrow(new RuntimeException("Movie not found"));

        BaseResponse response = movieController.getMovieById(id);

        assertFalse(response.getSuccess());
        assertEquals("Movie not found", response.getMessage());
        assertNull(response.getData());
    }

    @Test
    void testUpdateMovie_Exception() {
        int id = 1;
        MovieDto movieDto = new MovieDto("Title1", "Description1", 8.0f, "image1.jpg");
        when(mapperFacade.map(movieDto, Movie.class)).thenReturn(new Movie());
        when(movieService.updateMovie(eq(id), any(Movie.class))).thenThrow(new RuntimeException("Update failed"));

        BaseResponse response = movieController.updateMovie(id, movieDto);

        assertFalse(response.getSuccess());
        assertEquals("Update failed", response.getMessage());
        assertNull(response.getData());
    }

    @Test
    void testDeleteMovie_Exception() {
        int id = 1;
        when(movieService.deleteMovie(id)).thenThrow(new RuntimeException("Delete failed"));

        BaseResponse response = movieController.deleteMovie(id);

        assertFalse(response.getSuccess());
        assertEquals("Delete failed", response.getMessage());
        assertNull(response.getData());
    }
}
