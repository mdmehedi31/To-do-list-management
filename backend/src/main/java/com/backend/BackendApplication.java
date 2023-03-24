package com.backend;

import com.backend.entity.User;
import com.backend.enums.UserType;
import com.backend.service.definition.CreateUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);

        System.out.println("Hello Code is running..");

    }


}
