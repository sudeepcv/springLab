package com.sudeepcv;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {

        // List<Person> people = new ArrayList<>();

        // for (int i = 0; i < 5; i++) {
        // Person person = new Person();
        // person.setName("Sudeep cv" + i);
        // person.setAge(29);
        // people.add(person);
        // }

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // entityManager.find(Person.class,1l);

        entityManager.getTransaction().begin();

        Person person = new Person();
        person.setName("Sudeep cv");
        person.setAge(29);
        entityManager.persist(person);
        System.out.println("----------------------------------------saving--------------------");

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
