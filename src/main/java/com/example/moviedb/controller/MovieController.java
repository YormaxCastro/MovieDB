package com.example.moviedb.controller;


import com.example.moviedb.services.ApiService;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
public class MovieController {

    private ApiService apiService;

     public MovieController(ApiService apiService){
         this.apiService = apiService;
     }

     @RequestMapping({"","/","/index"})
    public String index(Model model){
         model.addAttribute("popularMovies",apiService.getPopularMovies());
         return "index";
     }

}
