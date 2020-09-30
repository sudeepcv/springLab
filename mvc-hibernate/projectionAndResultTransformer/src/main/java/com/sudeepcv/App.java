package com.sudeepcv;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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

        Criteria cr = session2.createCriteria(Person.class);
        cr.add(Restrictions.eq("name", "Sudeep cv1"));
        cr.add(Restrictions.eq("age", 29));
        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.property("name"));
        projectionList.add(Projections.property("age"));
        cr.setProjection(projectionList);
        // cr.setResultTransformer(new AliasToBeanResultTransformer(Person.class));
        // Criteria.ALIAS_TO_ENTITY_MAP
        cr.setResultTransformer(CriteriaSpecification.PROJECTION);

        List<Object[]> list = cr.list();

        for (Object[] resultset : list) {
            System.out.println("name:" + resultset[0]);
            System.out.println("age:" + resultset[1]);
        }

        session2.getTransaction().commit();
        session2.close();

    }
}