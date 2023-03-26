package com.backend.service.implementation;

import com.backend.enums.UserType;
import com.backend.request.UserRequest;
import com.backend.entity.User;
import com.backend.repository.UserRepository;
import com.backend.service.definition.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateUserServiceImpl implements CreateUserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserRequest userRequest) {

            User user1= new User();
            user1.setUserName("admin");
            user1.setPassword("12345");
            user1.setUserType(UserType.ADMIN);
            userRepository.save(user1);


            User user2= new User();
            user2.setUserName("user1");
            user2.setPassword("2345");
            user2.setUserType(UserType.USER);
            userRepository.save(user2);


         return user1;

    }

    @Override
    public User getUser(String userName) {
        return this.userRepository.findByUserName(userName);
    }

}
