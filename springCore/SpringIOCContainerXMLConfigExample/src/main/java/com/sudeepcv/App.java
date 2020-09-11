package com.sudeepcv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("configurationMetadata.xml");
        Person p2=context.getBean("Person",Person.class);
        System.out.println(p2.getName());
    }
}
