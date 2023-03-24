package com.backend.service.definition;

import com.backend.dto.UserDto;
import com.backend.entity.User;

public interface CreateUserService {


    public User createUser(UserDto userDto);

    public User getUser(String userName);
}
