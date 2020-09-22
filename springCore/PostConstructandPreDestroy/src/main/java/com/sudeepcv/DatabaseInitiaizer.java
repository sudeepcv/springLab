package com.sudeepcv;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class DatabaseInitiaizer {

    @PostConstruct
    public void init() {
        System.out.println("init");

    }
    @PreDestroy
    public void destroy() {
        System.out.println("destroy");

    }

}
