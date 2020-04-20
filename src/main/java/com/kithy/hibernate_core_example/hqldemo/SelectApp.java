package com.kithy.hibernate_core_example.hqldemo;

import com.kithy.hibernate_core_example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class SelectApp {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        String select = "select firstName, lastName from Employee";
        String select2 = "select e.firstName, e.lastName from Employee as e";
        String select3 = "select e.firstName, e.lastName from Employee e";
        Query query = session.createQuery(select2);
        query.setMaxResults(10);
        List<Object[]> resultList = query.getResultList();

        session.getTransaction().commit();
        factory.close();
        for (Object[] names : resultList) {
            System.out.println(names[0] + " " + names[1]);

        }
    }
}
