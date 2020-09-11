package com.sudeepcv;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p2=context.getBean("person",Person.class);
        String [] beans=context.getBeanDefinitionNames();
        for(String bean:beans){
            System.out.println("Bean name: "+bean);
        }
    }
}
