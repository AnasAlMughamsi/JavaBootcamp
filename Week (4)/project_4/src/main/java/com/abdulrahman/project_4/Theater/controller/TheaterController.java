package com.abdulrahman.project_4.Theater.controller;

import com.abdulrahman.project_4.Theater.model.Theater;
import com.abdulrahman.project_4.Theater.service.TheaterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/theater")
@RequiredArgsConstructor
public class TheaterController {
    final TheaterService theaterService;
    @GetMapping("/get")
    public List<Theater> readMovies(){
        return theaterService.getMovie();
    }
    @PostMapping("/add")
    public ResponseEntity createMovies(@RequestBody @Valid Theater theater) {

        theaterService.addMovie(theater);
        return ResponseEntity.status(200).body("Added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateMovies(@PathVariable Integer id, @RequestBody @Valid Theater theater, Errors errors){

        theaterService.editMovie(id, theater);
        return ResponseEntity.status(200).body("Movie modified!");

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovies(@PathVariable Integer id){

        theaterService.deleteMovie(id);
        return ResponseEntity.status(200).body("Movie deleted!");

    }

}
