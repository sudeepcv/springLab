package com.sudeepcv.todoapp.service;

import com.sudeepcv.todoapp.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class TodoServiceImpl implements TodoService {

    private static List<Todo> todos = new ArrayList<>();
    private static int idCounter = 0;

    static {
        for (int i = 0; i < 5; i++) {
            todos.add(new Todo(++idCounter, "sudeepcv", "description" + idCounter, new Date(), false));
        }
    }


    @Override
    public List<Todo> getAllTodos() throws InterruptedException {

        Thread.sleep(3000);
        return todos;
    }

    public Todo deleteById(long id){
        Todo todo=findById(id);
        if(todo==null)
            return  null;
        if(todos.remove(todo)) {
            return todo;
        }
        else{
            return  null;
        }

    }

    public Todo findById(long id) {
        for(Todo todo:todos){
            if(todo.getId()==id){
                return  todo;
            }
        }
        return  null;
    }

    public  Todo save(Todo todo){
        if(todo.getId()==-1 || todo.getId()==0){
            todo.setId(++idCounter);
            todos.add(todo);

        }else {
            deleteById(todo.getId());
            todos.add(todo);

        }
        return  todo;

    }
}
