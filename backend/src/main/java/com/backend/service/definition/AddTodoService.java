package com.backend.service.definition;

import com.backend.entity.Todo;
import com.backend.request.TodoRequest;

import java.util.List;

public interface AddTodoService {

    public Todo addTodo(Long userId, TodoRequest todoRequest);

    public void deleteTodo(Long userId, Long todoId);

    public List<Todo> getTodoByUserId(Long userId);

}
