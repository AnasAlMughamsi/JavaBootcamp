package com.example.blog.service;

import com.example.blog.api.ApiException;
import com.example.blog.model.MyUser;
import com.example.blog.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserService {

    private final MyUserRepository myUserRepository;

    public List<MyUser> myUsersList() {
        return myUserRepository.findAll();
    }

    public MyUser getUser(Integer id) {
        MyUser myUser = myUserRepository.findMyUserById(id);
        if(myUser == null) {
            throw new ApiException("user not found, wrong id");
        }
        return myUser;
    }

    public void userRegister(MyUser newUser) {
        newUser.setRole("user");
        String hashedPassword = new BCryptPasswordEncoder().encode(newUser.getPassword());
        newUser.setPassword(hashedPassword);
        myUserRepository.save(newUser);
    }

    public void updateUser(Integer id, MyUser updateUser) {
        MyUser oldUser = myUserRepository.findMyUserById(id);
        if(oldUser == null) {
            throw new ApiException("user not found, wrong id");
        }
        updateUser.setId(id);
        updateUser.setRole(oldUser.getRole());
        updateUser.setPassword(new BCryptPasswordEncoder().encode(updateUser.getPassword()));
        myUserRepository.save(updateUser);
    }

    public void deleteUser(Integer id) {
        MyUser myUser = myUserRepository.findMyUserById(id);
        if(myUser == null) {
            throw new ApiException("user not found, wrong id");
        }
        myUserRepository.delete(myUser);
    }



}
