package com.backend.controller;


import com.backend.entity.User;
import com.backend.repository.UserRepository;
import com.backend.request.TodoRequest;
import com.backend.service.definition.AddTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/todo")
public class TodoController {


    @Autowired
    private AddTodoService addTodoService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add/{userId}")
    public void addTodd(@PathVariable Long userId, @RequestBody TodoRequest todoRequest){
        this.addTodoService.addTodo(userId,todoRequest);
    }
}
