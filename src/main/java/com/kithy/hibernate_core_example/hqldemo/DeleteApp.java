package com.kithy.hibernate_core_example.hqldemo;

import com.kithy.hibernate_core_example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DeleteApp {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        int idEmployee = 1;
        String delete = "delete Employee e where e.idEmployee=:id";

        Query query = session.createQuery(delete);
        query.setParameter("id", idEmployee);
        int i = query.executeUpdate(); // zwraca ilość wierszy które zostały zmienione

        session.getTransaction().commit();
        factory.close();

    }
}
