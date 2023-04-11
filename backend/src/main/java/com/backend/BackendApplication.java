package com.backend;

import com.backend.entity.User;
import com.backend.enums.UserType;
import com.backend.repository.UserRepository;
import com.backend.request.UserRequest;
import com.backend.service.definition.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner{

    @Autowired
    private CreateUserService createUserService;

    @Autowired
    private UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
            }
    @Override
    public void run(String... args) throws Exception {

        Optional<User> aUser= userRepository.findByUserName("admin");
        Optional<User> bUser= userRepository.findByUserName("user1");

        if (aUser.isEmpty() && bUser.isEmpty()){
            UserRequest userRequest = new UserRequest();
            this.createUserService.createUser(userRequest);
        }
        else {
            System.out.println("Admin and User1 already Exist");
        }
    }
}
