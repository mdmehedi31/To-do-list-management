package com.backend.controller;


import com.backend.entity.Todo;
import com.backend.entity.User;
import com.backend.repository.TodoRepository;
import com.backend.repository.UserRepository;
import com.backend.request.TodoRequest;
import com.backend.service.definition.AddTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
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
    public void addTodo(@PathVariable Long userId, @RequestBody TodoRequest todoRequest){
      Todo addTodo=  this.addTodoService.addTodo(userId,todoRequest);

    }

    @DeleteMapping("/delete/{userId}/{todoId}")
    public void deleteTodo(@PathVariable Long userId,@PathVariable Long todoId){
        this.addTodoService.deleteTodo(userId,todoId);
    }


    /*@GetMapping("/get")
    @SendTo("/topic/messages")*/

    @MessageMapping("/get")
    public List<Todo> getTodoByUserId(){

        return this.todoRepository.findAll();
    }

    @PostMapping("/done/{userId}/{todoId}")
    public void todoDone(@PathVariable Long todoId, @PathVariable Long userId){

        User user=this.userRepository.findById(userId).orElseThrow(()-> new NoSuchElementException());

       // System.out.println("User is "+user.getUserName()+" "+user.getPassword()+" "+user.getUserType());
        Todo todo=  user.getTodoList().
                stream().
                filter(todo1 -> todo1.getTodoId().equals(todoId)).findFirst().orElseThrow();

        todo.setDone(!todo.getDone());
        todoRepository.save(todo);
    }
}
