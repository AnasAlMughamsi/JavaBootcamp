package com.example.movie.service;


import com.example.movie.exception.ApiException;
import com.example.movie.model.Director;
import com.example.movie.model.Movie;
import com.example.movie.repository.DirectorRepository;
import com.example.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService {

    private final DirectorRepository directorRepository;
    private final MovieRepository movieRepository;
    public List<Director> getDirectors() {
        return directorRepository.findAll();
    }

    public void addDirector(Director newDirector) {
        directorRepository.save(newDirector);
    }

    public void updateDirector(Integer id, Director updateDirector) {
        Director director = directorRepository.findDirectorById(id);

        if(director == null) {
            throw new ApiException("Can't find the director");
        }
        updateDirector.setId(id);
        directorRepository.save(updateDirector);
    }

    public void deleteDirector(Integer id) {
        Director director = directorRepository.findDirectorById(id);
        if(director == null) {
            throw new ApiException("Can't find the director, wrong id");
        }
        directorRepository.delete(director);
    }

    public List<Movie> findMoviesByDirectorId(Integer id) {
        Director directorId = directorRepository.findDirectorById(id);
        if(directorId == null) {
            throw new ApiException("Can't find direction with this id");
        }
        List<Movie> movies = movieRepository.findAll();
        if(movies.contains(directorId)) {
            return movies;
        }
        throw new ApiException("This director has no movies");
    }
}
