package com.sudeepcv;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
    public static void main(String[] args) {

        Name name = new Name();
        name.setLastName("cvs");
        name.setFirstName("sudeep");
        Person person = new Person();
        person.setName(name);
        person.setAge(29);

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Person.class);
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
                .buildServiceRegistry();

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);

        transaction.commit();
    }
}