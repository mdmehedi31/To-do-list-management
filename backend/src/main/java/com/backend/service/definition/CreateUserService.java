package com.backend.service.definition;

import com.backend.request.UserRequest;
import com.backend.entity.User;

import java.util.Optional;

public interface CreateUserService {


    public User createUser(UserRequest userRequest);

    public Optional<User> getUser(String userName);
}
