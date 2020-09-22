package com.sudeepcv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;
    private Address address;

    @Autowired
    public Person(@Qualifier("HomeAddress") Address address) {
        super();
        this.address = address;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
