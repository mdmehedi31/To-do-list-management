package com.backend.service.implementation;


import com.backend.entity.User;
import com.backend.entity.UserEntityDetails;
import com.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserInfoDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Optional<User> user= userRepository.findByUserName(username);

        return user.map(UserEntityDetails::new).
                orElseThrow(()-> new UsernameNotFoundException("User name not found "+username));
    }
}
