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

//    public Director directorByMovieTitle(String title) {
//        Movie movieTitle = movieRepository.findMovieByName(title);
//        Director director = new Director();
//        if(director.getId() == movieTitle.getDirectorID()) {
//            return director.getName();
//        }
//        return "can't find the director with that name";
//    }
}
