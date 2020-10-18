package com.sudeepcv.todoapp.service;

import com.sudeepcv.todoapp.model.Todo;

import java.util.List;


public interface TodoService {
    List<Todo> getAllTodos() throws InterruptedException;

    Todo deleteById(long id);

    Todo findById(long id);

    Todo save(Todo todo);
}
