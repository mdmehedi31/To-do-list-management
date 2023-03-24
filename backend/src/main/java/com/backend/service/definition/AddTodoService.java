package com.backend.service.definition;

import com.backend.entity.Todo;
import com.backend.request.TodoRequest;

public interface AddTodoService {

    public Todo addTodo(Long userId, TodoRequest todoRequest);

}
