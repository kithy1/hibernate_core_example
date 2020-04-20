package com.kithy.hibernate_core_example;

import com.kithy.hibernate_core_example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RollBackTest {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Employee employee = new Employee();
        employee.setFirstName("Jakub");
        employee.setLastName("Nowakowski");
        employee.setSalary(6000);
        session.save(employee);
//        session.getTransaction().commit();
//        session = factory.getCurrentSession();
//        session.beginTransaction();
        Employee employee1 = session.get(Employee.class, 12);
        employee1.setSalary(10000);
        session.update(employee1); // jeśli w ramach jednej transakcji wystąpi błąd cała transakcja nie dojdzie do skutku
        session.getTransaction().commit();
        factory.close();
    }
}
