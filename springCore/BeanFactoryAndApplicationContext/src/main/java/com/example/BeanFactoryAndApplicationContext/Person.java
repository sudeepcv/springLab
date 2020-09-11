package com.example.BeanFactoryAndApplicationContext;

public class Person {
    public static boolean isBeanInstantiated = false;

    public Person() {
        System.out.println("Person class created");
    }

    public static boolean isIsBeanInstantiated() {
        return isBeanInstantiated;
    }

    public static void setIsBeanInstantiated(boolean isBeanInstantiated) {
        Person.isBeanInstantiated = isBeanInstantiated;
    }

    public void postConstruct() {
        setIsBeanInstantiated(true);
    }
}
