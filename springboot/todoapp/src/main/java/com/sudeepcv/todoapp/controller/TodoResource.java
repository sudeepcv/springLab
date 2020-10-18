package com.sudeepcv.todoapp.controller;

import com.sudeepcv.todoapp.model.Todo;
import com.sudeepcv.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class TodoResource {

    @Autowired
    private TodoService todoService;

    @GetMapping("users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) throws InterruptedException {
        List<Todo> todos = new ArrayList<>();
        todos = todoService.getAllTodos();
        return todos;
    }

    @GetMapping("users/{username}/todos/{id}")
    public Todo getTodoByid(@PathVariable String username,@PathVariable long id) throws InterruptedException {

        Todo todos = todoService.findById(id);
        return todos;
    }

    @PutMapping("users/{username}/todos/{id}")
    public ResponseEntity<Todo> update(@PathVariable String username,@PathVariable long id , @RequestBody Todo todo) throws InterruptedException {
        Todo todoUpdated = todoService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @PostMapping("users/{username}/todos")
    public ResponseEntity<Void> update(@PathVariable String username, @RequestBody Todo todo) throws InterruptedException {
        Todo createdTodo = todoService.save(todo);

       URI uri= ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return  ResponseEntity.created(uri).build();
    }


    @DeleteMapping("users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username,@PathVariable long id) {
        Todo todo=todoService.deleteById(id);
        if(todo !=null){
            return  ResponseEntity.noContent().build();
        }else {
            return  ResponseEntity.notFound().build();
        }

    }
}
