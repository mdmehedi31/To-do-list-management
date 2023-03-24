package com.backend.request;


import com.backend.enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private String userName;
    private String password;
    private UserType userType;
}
