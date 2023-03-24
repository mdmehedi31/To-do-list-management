package com.backend.service.definition;

import com.backend.request.UserRequest;
import com.backend.entity.User;

public interface CreateUserService {


    public User createUser(UserRequest userRequest);

    public User getUser(String userName);
}
