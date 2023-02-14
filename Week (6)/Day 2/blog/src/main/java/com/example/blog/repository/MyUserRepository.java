package com.example.blog.repository;

import com.example.blog.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Integer> {

    MyUser findMyUserById(Integer id);
    MyUser findMyUserByUsername(String username);
}
