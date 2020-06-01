package com.example.moviedb.services;

import com.example.moviedb.api.domain.Movie;
import java.util.List;

public interface ApiService {

    List<Movie> getNowPlayingMovies();
    List<Movie> getUpcomingMovies();
    List<Movie> getTopRatedMovies();
    List<Movie> getPopularMovies();


    List<Movie> getMoviesByKeyword(String keyword);
    Movie getMovieByid(int id);



}