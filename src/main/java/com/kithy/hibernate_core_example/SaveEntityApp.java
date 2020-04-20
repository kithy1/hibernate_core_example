package com.kithy.hibernate_core_example;

import com.kithy.hibernate_core_example.entity.Book;
import com.kithy.hibernate_core_example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveEntityApp {
    public static void main(String[] args) {
        //stworzenie obiektu Configuration
        Configuration conf = new Configuration();
        //wczytanie pliku konfiguracyjnego
        conf.configure("hibernate.cfg.xml");
        //wczytanie adnotacji
        conf.addAnnotatedClass(Employee.class);
        //stworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();
        //pobranie sesji
        Session session = factory.getCurrentSession();
        //stworzenie obiektu

        //rozpoczęcie transakcji
        session.beginTransaction();
        //zapisanie obiektu
       // Employee employee1 = session.get(Employee.class, 1);
        Employee employee = session.get(Employee.class, 4);
        employee.setSalary(7000);
        session.update(employee);
        //zakończenie transakcji
        session.getTransaction().commit();
        //zamknięcie obiektu SessionFactory
        factory.close();
        //System.out.println(employee1);
    }
}
