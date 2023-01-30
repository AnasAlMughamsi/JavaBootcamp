package com.example.homework.service;

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
        oldUser.setUsername(updateUser.getUsername());
        oldUser.setPassword(updateUser.getPassword());
        oldUser.setEmail(updateUser.getEmail());
        oldUser.setRole(updateUser.getRole());
        oldUser.setAge(updateUser.getAge());
        userRepository.save(oldUser);
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


}
