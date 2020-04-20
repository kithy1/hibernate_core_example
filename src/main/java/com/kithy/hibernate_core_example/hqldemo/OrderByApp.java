package com.kithy.hibernate_core_example.hqldemo;

import com.kithy.hibernate_core_example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class OrderByApp {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String orderBy = "select e.firstName, e.lastName from Employee e order by e.firstName";
        String orderBy2 = "select e.firstName, e.lastName from Employee e order by e.firstName desc";
        String orderBy3 = "select e.firstName, e.lastName, e.salary from Employee e order by e.salary desc, e.lastName asc";
        Query query = session.createQuery(orderBy3);
//        query.setMaxResults(10);
        List<Object[]> resultList = query.getResultList();
        session.getTransaction().commit();
        factory.close();
        for (Object[] objects : resultList) {
            System.out.println(objects[0] + " " + objects[1]+" "+objects[2]);
        }
    }
}
