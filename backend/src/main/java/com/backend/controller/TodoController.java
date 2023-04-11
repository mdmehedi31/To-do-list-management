package com.backend.controller;


import com.backend.entity.Todo;
import com.backend.entity.User;
import com.backend.repository.TodoRepository;
import com.backend.repository.UserRepository;
import com.backend.request.TodoRequest;
import com.backend.service.definition.AddTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/todo")
@CrossOrigin("*")
public class TodoController {

    @Autowired
    private AddTodoService addTodoService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoRepository todoRepository;

    @PostMapping("/add/{userId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void addTodo(@PathVariable Long userId, @RequestBody TodoRequest todoRequest){
      Todo addTodo=  this.addTodoService.addTodo(userId,todoRequest);

    }

    @DeleteMapping("/delete/{userId}/{todoId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void deleteTodo(@PathVariable Long userId,@PathVariable Long todoId){
        this.addTodoService.deleteTodo(userId,todoId);
    }


    /*
    @MessageMapping("/get")

    @SendTo("/topic/messages")*/


    @GetMapping("/get")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public List<Todo> getTodoByUserId(){
        return this.todoRepository.findAll();
    }


    //{userId}
    @PostMapping("/done/{userId}/{todoId}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public void todoDone(@PathVariable Long userId, @PathVariable Long todoId){

        User user=this.userRepository.findById(userId).orElseThrow(()->
                new NoSuchElementException(userId+" this id is not found."));

        System.out.println("user details is : "+user.getUserName()+" "+user.getUserId()+" "+user.getPassword());
       // System.out.println("User is "+user.getUserName()+" "+user.getPassword()+" "+user.getUserType());
        Todo todo=  user.getTodoList().
                stream().
                filter(todo1 -> todo1.getTodoId().equals(todoId)).findFirst().orElseThrow();

        todo.setDone(!todo.getDone());
        todoRepository.save(todo);
    }
}
