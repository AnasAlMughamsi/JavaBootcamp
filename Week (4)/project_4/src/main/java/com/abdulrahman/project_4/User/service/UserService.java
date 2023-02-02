package com.abdulrahman.project_4.User.service;

import com.abdulrahman.project_4.Movie.model.Movie;
import com.abdulrahman.project_4.Movie.repository.MovieRepo;
import com.abdulrahman.project_4.Theater.model.Theater;
import com.abdulrahman.project_4.Theater.repository.TheaterRepo;
import com.abdulrahman.project_4.User.model.User;
import com.abdulrahman.project_4.User.repository.UserRepo;
import com.abdulrahman.project_4.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final MovieRepo movieRepo;
    private final TheaterRepo theaterRepo;

    public List<User> getUser() {
        List<User> users = userRepo.findAll();
        return users;
    }
    public void addUser(User user) {

        userRepo.save(user);
    }
    public boolean editUser(Integer id, User user) {
        User temp_User = userRepo.findById(id).get();
        if (temp_User == null) {
            return false;
        }

        temp_User.setName(user.getName());
        temp_User.setIsPresent(user.getIsPresent());
        temp_User.setMovieID(user.getMovieID());
        temp_User.setTheaterID(user.getTheaterID());

        try{
            userRepo.save(temp_User);
            return true;

        }catch (DataIntegrityViolationException e){
            return false;
        }
    }
    public boolean deleteUser(Integer id) {
        User temp_User = userRepo.getById(id);
        if (temp_User == null) {
            return false;
        }
        userRepo.delete(temp_User);
        return true;
    }

    public void userBookMovie(Integer id) {
        List<Movie> movies = movieRepo.findAll();
        User user = userRepo.findUserById(id);
        List<Theater> theaters = theaterRepo.findAll();

        if(movies.isEmpty()) {
            throw new ApiException("Movie not available");d
        }
        if(theaters.isEmpty()) {
            throw new ApiException("No theater is available, try tomorrow");
        }
        Theater newTheater = new Theater();

//        for (int i = 0; i < theaters.size(); i++) {
//
//            theaters.get(i).getCapacity() - 1;
//        }

    }

}
