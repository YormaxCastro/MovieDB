package com.example.moviedb.services;

import com.example.moviedb.api.domain.Movie;
import java.util.List;

public interface ApiService {

    List<Movie> getPopularMovies(Integer limit);
}