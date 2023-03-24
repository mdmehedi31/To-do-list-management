package com.backend.service.implementation;

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


        User user= new User();

        user.setUserName(userRequest.getUserName());
        user.setPassword(userRequest.getPassword());
        user.setUserType(userRequest.getUserType());


         return userRepository.save(user);

    }

    @Override
    public User getUser(String userName) {
        return this.userRepository.findByUserName(userName);
    }

}
