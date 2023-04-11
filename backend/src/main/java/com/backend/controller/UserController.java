package com.backend.controller;


import com.backend.request.UserRequest;
import com.backend.entity.User;
import com.backend.service.definition.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CreateUserService createUserService;


    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to the Todo management list......";
    }
    @PostMapping("/create")
    public User createUser(@RequestBody UserRequest userRequest){
        return this.createUserService.createUser(userRequest);
    }

    @GetMapping("/getuser/{username}")
    public Optional<User> getUser(@PathVariable("username") String userName){
       return  this.createUserService.getUser(userName);
    }


}
