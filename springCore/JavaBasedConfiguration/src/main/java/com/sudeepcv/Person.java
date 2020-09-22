package com.sudeepcv;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class Person {
    private String name;

    public Person() {
        System.out.println("preson created");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
