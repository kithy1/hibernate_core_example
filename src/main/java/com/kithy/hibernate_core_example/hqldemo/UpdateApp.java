package com.kithy.hibernate_core_example.hqldemo;

import com.kithy.hibernate_core_example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class UpdateApp {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        int idEmployee = 1;
        int salary = 30000;
        String update = "update Employee e set e.salary=:newSalary where e.idEmployee=:id";

        Query query = session.createQuery(update);
        query.setParameter("newSalary",salary);
        query.setParameter("id", idEmployee);
        query.executeUpdate();

        session.getTransaction().commit();
        factory.close();

    }
}
