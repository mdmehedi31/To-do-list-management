package com.backend.service.implementation;

import com.backend.entity.Todo;
import com.backend.entity.User;
import com.backend.repository.TodoRepository;
import com.backend.repository.UserRepository;
import com.backend.request.TodoRequest;
import com.backend.service.definition.AddTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AddTodoServiceImpl implements AddTodoService {


    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Override
    public Todo addTodo(Long userId,TodoRequest todoRequest) {


        User user= this.userRepository.findById(userId).orElseThrow(()->new NoSuchElementException());

        Todo addTodo= new Todo();
        addTodo.setTodoTitle(todoRequest.getTodoTitle());
        addTodo.setTodoTask(todoRequest.getTodoTask());
        user.getTodoList().add(addTodo);

        Todo todoAdd =todoRepository.save(addTodo);

        simpMessagingTemplate.convertAndSend("/topic/todos", todoAdd);
        return todoAdd;
    }
}
