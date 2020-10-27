package com.sudeepcv.todoapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AuthResource {

    @GetMapping(path="basicauth")
    public Map<String ,String> authentication(){
        Map<String ,String> auth= new HashMap<>();
        auth.put("message","authenticated");

        return auth;
    }

}
