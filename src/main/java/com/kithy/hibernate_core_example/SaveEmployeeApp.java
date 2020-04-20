package com.kithy.hibernate_core_example;

import com.kithy.hibernate_core_example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

public class SaveEmployeeApp {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Employee employee = new Employee();
        employee.setFirstName("Urszula");
        employee.setLastName("Białkowska");
        employee.setSalary(7000);
        int employeeId = (int) session.save(employee);
        session.getTransaction().commit();
        factory.close();
    }


}
