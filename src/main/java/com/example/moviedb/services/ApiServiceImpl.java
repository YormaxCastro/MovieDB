package com.example.moviedb.services;

import com.example.moviedb.api.domain.Movie;
import com.example.moviedb.api.domain.MovieResult;
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
    private  String api_key;

    public ApiServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;

    }


    @Override
    public List<Movie> getPopularMovies(Integer limit) {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .path("/movie/popular")
                .queryParam("api_key", api_key)
                .queryParam("limit", limit);

        MovieResult movieResult = restTemplate.getForObject(uriBuilder.toUriString(), MovieResult.class);
        return movieResult.getResults();
    }
}
