package com.sudeepcv;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Person person = new Person();
            person.setName("Sudeep cv" + i);
            person.setAge(29);
            people.add(person);
        }
        Person p = null;
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Person.class);

        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
                .buildServiceRegistry();

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        for (Person pe : people) {
            session.save(pe);
        }
        session.getTransaction().commit();
        session.close();

        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        Query query2 = session2.createQuery("from Person where id=1l");
        query2.setCacheable(true);

        p = (Person) query2.uniqueResult();
        System.out.println("first Query out:" + p.getName());
        session2.getTransaction().commit();
        session2.close();

        Session session3 = sessionFactory.openSession();
        session3.beginTransaction();
        Query query3 = session3.createQuery("from Person where id=1l");
        query3.setCacheable(true);

        p = (Person) query3.uniqueResult();
        System.out.println("Second Query out:" + p.getName());
        session3.getTransaction().commit();
        session3.close();

    }
}
