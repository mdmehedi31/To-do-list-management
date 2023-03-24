package com.backend.controller;


import com.backend.entity.Todo;
import com.backend.entity.User;
import com.backend.repository.TodoRepository;
import com.backend.repository.UserRepository;
import com.backend.request.TodoRequest;
import com.backend.service.definition.AddTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/todo")
public class TodoController {


    @Autowired
    private AddTodoService addTodoService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoRepository todoRepository;

    @PostMapping("/add/{userId}")
    public void addTodo(@PathVariable Long userId, @RequestBody TodoRequest todoRequest){
        this.addTodoService.addTodo(userId,todoRequest);
    }

    @DeleteMapping("/delete/{userId}/{todoId}")
    public void deleteTodo(@PathVariable Long userId,@PathVariable Long todoId){

        User user= this.userRepository.findById(userId).orElseThrow(()->new NoSuchElementException());
        Todo todo= this.todoRepository.findById(todoId).orElseThrow(()->new NoSuchElementException());
        user.getTodoList().remove(todo);
        this.todoRepository.delete(todo);
    }


}
