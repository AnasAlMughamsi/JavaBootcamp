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
public class MovieService {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public void addMovie(Movie newMovie) {
        movieRepository.save(newMovie);
    }

    public void updateMovie(Integer id, Movie updateMovie) {
        Movie movie = movieRepository.findMovieById(id);
        if(movie == null) {
            throw new ApiException("Can't find the movie");
        }
        updateMovie.setId(id);
        movieRepository.save(updateMovie);
    }

    public void deleteMovie(Integer id) {
        Movie movie = movieRepository.findMovieById(id);
        if(movie == null) {
            throw new ApiException("Can't find the movie, wrong id");
        }

        movieRepository.delete(movie);
    }

    public Movie getMovieByTitle(String movieName) {
//        Movie movie = movieRepository.findMovieById(id);
        Movie movie = movieRepository.findMovieByName(movieName);
        if(movie == null) {
            throw new ApiException("Can't find the title of the movie");
        }
        return movie;
    }

    public Movie getMovieByGenre(String genre) {
        Movie movieByGenre = movieRepository.findMovieByGenre(genre);
        if(movieByGenre == null) {
            throw new ApiException("Can't find movie with this genre");
        }
        return movieByGenre;
    }

    public List<Movie> getMovieByRate(int rate) {
        List<Movie> movies = movieRepository.findMovieByRateAndMore(rate);
        if(movies.isEmpty()) {
            throw new ApiException("Can't find movies with above this rate");
        }
        return movies;
    }

    public Movie getMovieRatingByTitle(String title) {
        Movie movie = movieRepository.findMovieByName(title);
        if(movie == null) {
            throw new ApiException("Can't find movie rate with this title");
        }
        return movie;
    }

    public Movie getMovieDurationByTitle(String title) {
        Movie movie = movieRepository.findMovieByName(title);
        if(movie == null) {
            throw new ApiException("Can't find movie duration with this title");
        }
        return movie;
    }

    public Director findDirectorByMovieTitle(String title) {
        Movie movie = movieRepository.findMovieByName(title);
        if(movie == null) {
            throw new ApiException("Can't find movie title");
        }
        Director directorName = directorRepository.findDirectorById(movie.getDirectorID());
        if(movie.getDirectorID() == directorName.getId()) {
            return directorName;

        }
        throw new ApiException("Can't find the director by the movie name");
    }
}
