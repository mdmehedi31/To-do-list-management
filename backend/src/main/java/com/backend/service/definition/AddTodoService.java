package com.backend.service.definition;

import com.backend.request.TodoRequest;

public interface AddTodoService {

    public void addTodo(Long userId,TodoRequest todoRequest);

}
