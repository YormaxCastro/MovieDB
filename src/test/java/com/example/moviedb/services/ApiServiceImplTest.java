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
        List<Movie> movies = apiService.getPopularMovies();
        assert(!movies.isEmpty());
    }

    @Test
    public void testGetNowPlayingMovies(){
        List<Movie> movies = apiService.getNowPlayingMovies();
        assert(!movies.isEmpty());
    }

    @Test
    public void testGetUpcomingMovies(){
        List<Movie> movies = apiService.getUpcomingMovies();
        assert(!movies.isEmpty());
    }

    @Test
    public void getTopRatedMovies(){
        List<Movie> movies = apiService.getTopRatedMovies();
        assert(!movies.isEmpty());
    }

    @Test
    public void testSearchMovieByKeyword(){
        List<Movie> movies = apiService.getMoviesByKeyword("Back to the Future");
        assert(!movies.isEmpty());
    }

    @Test
    public void testSearchMovieBy(){
        Movie movie = apiService.getMovieByid(105);
        assert(movie.getTitle().equals("Back to the Future"));
    }


}
