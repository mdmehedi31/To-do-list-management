package com.backend.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "todos")
@Getter
@Setter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "todoId")
    private Long todoId;

    @Column(name = "todoTitle")
    private String todoTitle;

    @Column(name = "todoTask")
    private String todoTask;

}
