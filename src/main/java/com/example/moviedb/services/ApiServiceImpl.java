package com.example.moviedb.services;

import com.example.moviedb.api.domain.Movie;
import com.example.moviedb.api.domain.MovieResult;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {
    private RestTemplate restTemplate;

    @Value("${api.url}")
    private String api_url;

    @Value("${api.key}")
    private String api_key;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }

    @Override
    public List<Movie> getNowPlayingMovies() {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .path("/movie/now_playing")
                .queryParam("api_key", api_key);

        MovieResult movieResult = restTemplate.getForObject(uriBuilder.toUriString(), MovieResult.class);
        return movieResult.getResults();
    }

    @Override
    public List<Movie> getUpcomingMovies() {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .path("/movie/upcoming")
                .queryParam("api_key", api_key);

        MovieResult movieResult = restTemplate.getForObject(uriBuilder.toUriString(), MovieResult.class);
        return movieResult.getResults();
    }

    @Override
    public List<Movie> getTopRatedMovies() {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .path("/movie/top_rated")
                .queryParam("api_key", api_key);

        MovieResult movieResult = restTemplate.getForObject(uriBuilder.toUriString(), MovieResult.class);
        return movieResult.getResults();

    }

    @Override
    public List<Movie> getPopularMovies() {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .path("/movie/popular")
                .queryParam("api_key", api_key);

        MovieResult movieResult = restTemplate.getForObject(uriBuilder.toUriString(), MovieResult.class);
        return movieResult.getResults();
    }

    @Override
    public List<Movie> getMoviesByKeyword(String keyword) {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .path("/search/movie")
                .queryParam("query",keyword)
                .queryParam("api_key", api_key);
        MovieResult movieResult = restTemplate.getForObject(uriBuilder.toUriString(), MovieResult.class);
        JsonNode jsonNode =restTemplate.getForObject(uriBuilder.toUriString(), JsonNode.class);
        System.out.println(jsonNode.toString());
        System.out.println(movieResult.getResults());
        System.out.println(movieResult.toString());
        System.out.println(uriBuilder.toUriString());
        return movieResult.getResults();
    }



    @Override
    public Movie getMovieById(Long id) {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .path("/movie/"+id)
                .queryParam("api_key", api_key);
        Movie movie = restTemplate.getForObject(uriBuilder.toUriString(), Movie.class);
        return movie;
    }


}
