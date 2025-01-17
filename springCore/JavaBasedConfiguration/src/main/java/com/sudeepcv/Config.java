package com.sudeepcv;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"com.sudeepcv"})
public class Config {
    @Bean
    @Scope("prototype") // default scope
    public Person person(){
        Person person=new Person();
        person.setName("sudeep cv from configuration");
        return person;
    }
}
