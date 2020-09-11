package com.sudeepcv;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Person p2=context.getBean("person",Person.class);
        String [] beans=context.getBeanDefinitionNames();
        for(String bean:beans){
            System.out.println("Bean name: "+bean);
        }


    }
}
