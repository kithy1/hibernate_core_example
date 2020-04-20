package com.kithy.hibernate_core_example;

import com.kithy.hibernate_core_example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Optional;
import java.util.stream.Stream;

public class DeleteEntityByNameApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Stream<Employee> employeeStream = session.createQuery("from Employee").getResultStream();
        employeeStream
                .filter(employee -> "Urszula".equals(employee.getFirstName()))
                .findAny()
                .ifPresent(employee -> employee.setSalary(employee.getSalary()+500));

        session.getTransaction().commit();
        factory.close();
    }
}
