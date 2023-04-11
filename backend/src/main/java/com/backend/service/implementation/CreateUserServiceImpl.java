package com.backend.service.implementation;

import com.backend.enums.UserType;
import com.backend.request.UserRequest;
import com.backend.entity.User;
import com.backend.repository.UserRepository;
import com.backend.service.definition.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CreateUserServiceImpl implements CreateUserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(UserRequest userRequest) {

            User user1= new User();
            user1.setUserName("admin");
            user1.setPassword(passwordEncoder.encode("12345"));
            user1.setUserType(String.valueOf(UserType.ROLE_ADMIN));
            userRepository.save(user1);


            User user2= new User();
            user2.setUserName("user1");
            user2.setPassword(passwordEncoder.encode("123456"));
            user2.setUserType(String.valueOf(UserType.ROLE_USER));
            userRepository.save(user2);

         return user1;
    }

    @Override
    public Optional<User> getUser(String userName) {
        return this.userRepository.findByUserName(userName);
    }
}
