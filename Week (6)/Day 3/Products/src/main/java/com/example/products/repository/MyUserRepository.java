package com.example.products.repository;

import com.example.products.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Integer> {

    MyUser findMyUserById(Integer id);
    MyUser findMyUserByUsername(String username);
}
