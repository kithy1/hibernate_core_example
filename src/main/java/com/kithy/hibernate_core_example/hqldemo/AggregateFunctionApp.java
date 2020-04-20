package com.kithy.hibernate_core_example.hqldemo;

import com.kithy.hibernate_core_example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class AggregateFunctionApp {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        String avg = "select avg(e.salary) from Employee e";
        String sum = "select sum(e.salary) from Employee e";
        String min = "select min(e.salary) from Employee e";
        String max = "select max(e.salary) from Employee e";
        String count = "select count(e) from Employee e";

//        Query query = session.createQuery(avg);
//        Double singleResult = (Double) query.getSingleResult();

//        Query query = session.createQuery(sum);
//        Long singleResult = (Long) query.getSingleResult();

//        Query query = session.createQuery(min);
//        Integer singleResult = (Integer) query.getSingleResult();

//        Query query = session.createQuery(max);
//        Integer singleResult = (Integer) query.getSingleResult();

        Query query = session.createQuery(count);
        Long singleResult = (Long) query.getSingleResult();

        session.getTransaction().commit();
        factory.close();
        System.out.println(singleResult);
    }
}
