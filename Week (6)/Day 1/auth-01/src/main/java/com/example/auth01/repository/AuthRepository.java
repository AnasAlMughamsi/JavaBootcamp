package com.example.auth01.repository;

import com.example.auth01.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<MyUser, Integer> {

    MyUser findMyUserByUsername(String username);
    MyUser findMyUserById(Integer id);
}
