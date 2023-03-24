package com.backend.service.implementation;

import com.backend.dto.UserDto;
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
    public User createUser(UserDto userDto) {


        User user= new User();

        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setUserType(userDto.getUserType());


         return userRepository.save(user);

    }

    @Override
    public User getUser(String userName) {
        return this.userRepository.findByUserName(userName);
    }

}
