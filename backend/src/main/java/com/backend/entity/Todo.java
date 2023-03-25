package com.backend.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "todoId")
    private Long todoId;

    @Column(name = "todoTitle")
    private String todoTitle;

    @Column(name = "todoTask")
    private String todoTask;

    @Column(name = "task_done")
    private Boolean done=false;


}
