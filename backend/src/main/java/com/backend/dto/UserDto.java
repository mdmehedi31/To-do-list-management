package com.backend.dto;


import com.backend.enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String userName;
    private String password;
    private UserType userType;
}
