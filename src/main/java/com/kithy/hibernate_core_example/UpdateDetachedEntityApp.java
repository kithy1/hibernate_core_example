package com.kithy.hibernate_core_example;

import com.kithy.hibernate_core_example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateDetachedEntityApp {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession(); // otwiera EntityManager
        session.beginTransaction();
        Employee employee = session.get(Employee.class, 5);
        session.getTransaction().commit();
        employee.setSalary(10000);
        session = factory.getCurrentSession();
        session.beginTransaction();
        session.update(employee);
        session.getTransaction().commit();
        factory.close();
    }
}
