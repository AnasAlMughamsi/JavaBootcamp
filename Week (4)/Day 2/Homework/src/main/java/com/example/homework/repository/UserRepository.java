package com.example.homework.repository;

import com.example.homework.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByEmail(String email);

    @Query("select x from User x where x.age >= ?1")
    List<User> findByAgeGreaterThanEqual(int age);

    @Query("select x from User x where x.email=?1 and x.password=?2")
    User checkEmailPassword(String email, String password);
    List<User> findAllByRole(String role);
    User findUserByRole(String role);
}
