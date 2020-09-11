package com.sudeepcv;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.sudeepcv"})
public class Config {
    @Bean
    public Person person(){
        Person person=new Person();
        person.setName("sudeep cv from configuration");
        return person;
    }
}
