package com.backend.entity;


import com.backend.enums.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;

    @OneToMany
    private List<Todo> todoList= new ArrayList<>();

}
