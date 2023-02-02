package com.example.movie.repository;


import com.example.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findMovieById(Integer id);
    Movie findMovieByName(String name);
    Movie findMovieByGenre(String genre);
    @Query("select rate from Movie rate where rate.rating > ?1")
    List<Movie> findMovieByRateAndMore(int rate);

}
