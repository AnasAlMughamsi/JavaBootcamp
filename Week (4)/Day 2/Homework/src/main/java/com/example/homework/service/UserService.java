package com.example.homework.service;

import com.example.homework.exception.ApiException;
import com.example.homework.model.User;
import com.example.homework.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean updateUser(Integer id, User updateUser) {
        User oldUser = userRepository.getById(id);
        if(oldUser == null) {
            return false;
        }
//        updateUser.setId(id);
//        oldUser.setUsername(updateUser.getUsername());
//        oldUser.setPassword(updateUser.getPassword());
//        oldUser.setEmail(updateUser.getEmail());
//        oldUser.setRole(updateUser.getRole());
//        oldUser.setAge(updateUser.getAge());
        updateUser.setId(id);
        userRepository.save(updateUser);
        return true;
    }

    public boolean deleteUser(Integer id) {
        User userToDelete = userRepository.getById(id);
        if(userToDelete == null) {
            return false;
        }
        userRepository.delete(userToDelete);
        return true;
    }

    // Homework - 18

    public List<User> getAllUser() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    public User findByEmail(String email) {
        User userByEmail = userRepository.findUserByEmail(email);
        if(userByEmail == null) {
            throw new ApiException("Can't find the email");
        }
        return userByEmail;
    }

    public List<User> searchByAge(int age) {

        List<User> userAge = userRepository.findByAgeGreaterThanEqual(age);
        if(userAge == null) {
            throw new ApiException("Can't find the age");
        }
        if(userAge.isEmpty()) {
            throw new ApiException("Can't find the age");
        }
        return userAge;
    }

    public List<User> searchAllByRole(String role) {
        List<User> usersRole = userRepository.findAllByRole(role);
        if(usersRole == null) {
            throw new ApiException("Can't fine the role");
        }
        return usersRole;
    }

    public void checkEmailPassword(User user) {
        if(user.getPassword() == null || user.getEmail() == null) {
            throw new ApiException("Cant find the email and password");
        }

        User userFetched = userRepository.checkEmailPassword(user.getEmail(), user.getPassword());
        if(userFetched.getEmail() == null || userFetched.getPassword() == null) {
            throw new ApiException("email or password are incorrect");
        }
    }

}
