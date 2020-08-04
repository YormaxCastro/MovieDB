package com.example.moviedb.controller;


import com.example.moviedb.services.ApiService;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
public class MovieController {

    private ApiService apiService;

     public MovieController(ApiService apiService){
         this.apiService = apiService;
     }

     @RequestMapping({"","/","/index"})
    public String index(Model model){
         model.addAttribute("popularMovies", apiService.getPopularMovies());
         model.addAttribute("upcomingMovies", apiService.getUpcomingMovies());
         model.addAttribute("topRatedMovies", apiService.getTopRatedMovies());
         model.addAttribute("playingNowMovies", apiService.getNowPlayingMovies());
         return "index";
     }
    @RequestMapping(value = "/movie")
    String getMovie(@RequestParam(value = "movieId", defaultValue = "100") String movieId) {
         System.out.print(movieId);
         return "movie"; // @TODO Create the movie html template and fix the mapping
    }

}
