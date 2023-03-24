package com.backend.controller;


import com.backend.request.UserRequest;
import com.backend.entity.User;
import com.backend.service.definition.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CreateUserService createUserService;


    @PostMapping("/create")
    public User createUser(@RequestBody UserRequest userRequest){

        return this.createUserService.createUser(userRequest);
    }

    @GetMapping("/getuser/{username}")
    public User getUser(@PathVariable("username") String userName){


       return  this.createUserService.getUser(userName);

    }
}
