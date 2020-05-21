package com.example.moviedb.services;

import com.example.moviedb.api.domain.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;




@SpringBootTest

public class ApiServiceImplTest {

    @Autowired
    ApiService apiService;

    @BeforeEach
    public void setUp() throws Exception{

    }

    @Test
    public void testGetPopularMovies(){

        List<Movie> movies = apiService.getPopularMovies(20);
        assertEquals(20, movies.size());
    }


}
