package com.abdulrahman.project_4.Movie.service;

import com.abdulrahman.project_4.Movie.model.Movie;
import com.abdulrahman.project_4.Movie.repository.MovieRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MovieService {
    final MovieRepo movieRepo;
    public List<Movie> getMovie() {
        List<Movie> movies = movieRepo.findAll();
        return movies;
    }
    public void addMovie(Movie movie) {

        movieRepo.save(movie);
    }
    public boolean editMovie(Integer id, Movie movie) {
        Movie temp_Movie = movieRepo.findById(id).get();
        if (temp_Movie == null) {
            return false;
        }

        temp_Movie.setTitle(movie.getTitle());
        temp_Movie.setDuration(movie.getDuration());
        temp_Movie.setGenre(movie.getGenre());
        temp_Movie.setPrice(movie.getPrice());


        try{
            movieRepo.save(temp_Movie);
            return true;

        }catch (DataIntegrityViolationException e){
            return false;
        }
    }
    public boolean deleteMovie(Integer id) {
        Movie temp_Movie = movieRepo.getById(id);
        if (temp_Movie == null) {
            return false;
        }
        movieRepo.delete(temp_Movie);
        return true;
    }
}
