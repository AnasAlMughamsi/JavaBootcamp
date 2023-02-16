package com.example.auth01.service;

import com.example.auth01.model.MyUser;
import com.example.auth01.repository.AuthRepository;
import com.example.auth01.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserService implements UserDetailsService {

    private final AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = authRepository.findMyUserByUsername(username);
        if(myUser == null) {
            throw new UsernameNotFoundException("Wrong password or username");
        }
        return myUser;
    }


}
