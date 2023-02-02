package com.example.movie.controller;


import com.example.movie.model.Director;
import com.example.movie.model.Movie;
import com.example.movie.service.DirectorService;
import com.example.movie.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    @GetMapping("/get")
    public ResponseEntity getMovies() {
        List<Movie> movies = movieService.getMovies();
        return ResponseEntity.status(200).body(movies);
    }

    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody Movie newMovie) {
        movieService.addMovie(newMovie);
        return ResponseEntity.status(200).body("New movie added!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie(@PathVariable Integer id, @Valid @RequestBody Movie updateMovie) {
        movieService.updateMovie(id, updateMovie);
        return ResponseEntity.status(200).body("update movie!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Movie deleted!!");
    }

    @GetMapping("/getbytitle/{movieTitle}")
    public ResponseEntity getByTitle(@PathVariable String movieTitle) {
        Movie movie = movieService.getMovieByTitle(movieTitle);
        return ResponseEntity.status(200).body(movie);
    }
    @GetMapping("/getbygenre/{genre}")
    public ResponseEntity getByGenre(@PathVariable String genre) {
        Movie movie = movieService.getMovieByGenre(genre);
        return ResponseEntity.status(200).body(movie);
    }

    @GetMapping("/get-movie-rate/{rate}")
    public ResponseEntity getByRate(@PathVariable int rate) {
        List<Movie> movie = movieService.getMovieByRate(rate);
        return ResponseEntity.status(200).body(movie);
    }

    @GetMapping("/get-rate-title/{title}")
    public ResponseEntity getRateByTitle(@PathVariable String title) {
        Movie movie = movieService.getMovieRatingByTitle(title);
        return ResponseEntity.status(200).body("Movie rate: " + movie.getRating());
    }

    @GetMapping("/get-duration-title/{title}")
    public ResponseEntity getDurationByTitle(@PathVariable String title) {
        Movie movie = movieService.getMovieDurationByTitle(title);
        return ResponseEntity.status(200).body("Movie duration: " + movie.getDuration());
    }

}
