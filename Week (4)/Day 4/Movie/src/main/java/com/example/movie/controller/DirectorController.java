package com.example.movie.controller;


import com.example.movie.model.Director;
import com.example.movie.model.Movie;
import com.example.movie.service.DirectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/director")
@RequiredArgsConstructor
public class DirectorController {

    private final DirectorService directorService;
    @GetMapping("/get")
    public ResponseEntity getDirectors() {
        List<Director> directors = directorService.getDirectors();
        return ResponseEntity.status(200).body(directors);
    }

    @PostMapping("/add")
    public ResponseEntity addDirector(@Valid @RequestBody Director newDirector) {
        directorService.addDirector(newDirector);
        return ResponseEntity.status(200).body("New director added!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDirector(@PathVariable Integer id, @Valid @RequestBody Director updateDirector) {
        directorService.updateDirector(id, updateDirector);
        return ResponseEntity.status(200).body("update director!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDirector(@PathVariable Integer id) {
        directorService.deleteDirector(id);
        return ResponseEntity.status(200).body("Director deleted!!");
    }

    @GetMapping("/get-movies/{id}")
    public ResponseEntity findMoviesByDirector(@PathVariable Integer id) {
        List<Movie> movies = directorService.findMoviesByDirectorId(id);
        return ResponseEntity.status(200).body(movies);
    }

}
