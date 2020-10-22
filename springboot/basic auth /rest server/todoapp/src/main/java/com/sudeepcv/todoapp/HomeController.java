package com.sudeepcv.todoapp;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class HomeController {

@GetMapping(path="/")
public String helloWorld(){
    return "test";
}

    
}