package com.backend.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {

    private String userName;
    private String password;
}
