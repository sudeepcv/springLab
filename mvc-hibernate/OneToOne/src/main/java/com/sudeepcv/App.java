package com.sudeepcv;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
    public static void main(String[] args) {

        Job job = new Job();
        job.setCompany("Piserve");
        job.setTitle("java developer");

        Person person = new Person();
        person.setName("Sudeep cv");
        person.setAge(29);
        person.setJob(job);

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Job.class);
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
                .buildServiceRegistry();

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(job);

        session.save(person);

        session.getTransaction().commit();
    }
}
