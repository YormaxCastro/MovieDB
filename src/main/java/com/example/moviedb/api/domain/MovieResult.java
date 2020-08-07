package com.example.moviedb.api.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.lang.builder.ToStringBuilder;

public class MovieResult implements Serializable {

    private final static long serialVersionUID = 420620315591775395L;

    private Integer page;

    private Integer totalResults;

    private Integer totalPages;

    private List<Movie> results = null;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("page", page).append("totalResults", totalResults).append("totalPages", totalPages).append("results", results).append("additionalProperties", additionalProperties).toString();
    }

}