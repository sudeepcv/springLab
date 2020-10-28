package com.sudeepcv.todoapp.controller;

import com.sudeepcv.todoapp.model.Todo;
import com.sudeepcv.todoapp.repository.TodoRepository;
import com.sudeepcv.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoResource {

//    @Autowired
//    private TodoService todoService;
    @Autowired
    private TodoRepository todoService;

    @GetMapping("/jpa/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) throws InterruptedException {
        List<Todo> todos = new ArrayList<>();
        todos = todoService.findByUsername(username);
        return todos;
    }

    @GetMapping("/jpa/users/{username}/todos/{id}")
    public Todo getTodoByid(@PathVariable String username,@PathVariable long id) throws InterruptedException {

        Todo todos = todoService.findById(id).get();
        return todos;
    }

    @PutMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Todo> update(@PathVariable String username,@PathVariable long id , @RequestBody Todo todo) throws InterruptedException {
        todo.setUsername(username);
        Todo todoUpdated = todoService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @PostMapping("/jpa/users/{username}/todos")
    public ResponseEntity<Void> create(@PathVariable String username, @RequestBody Todo todo)  {
        todo.setUsername(username);
        Todo createdTodo = todoService.save(todo);

       URI uri= ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return  ResponseEntity.created(uri).build();
    }


    @DeleteMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username,@PathVariable long id) {
        todoService.deleteById(id);
//        test
            return  ResponseEntity.noContent().build();
    }
}
