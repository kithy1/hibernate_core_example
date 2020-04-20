package com.kithy.hibernate_core_example.hqldemo;

import com.kithy.hibernate_core_example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class WhereApp {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        String where = "from Employee where firstName='Urszula'";
        String where2 = "from Employee where salary > 12000";
        String where3 = "from Employee where salary < 3000 or salary > 13000";
        String where4 = "from Employee where salary is null";
        String where5 = "from Employee where lastName in ('Nowak','Errazuriz')";

        Query query = session.createQuery(where2);
        query.setMaxResults(5);
        String queryString = query.getQueryString();
        List<Employee> employees = query.getResultList();

        employees.forEach(System.out::println);
        System.out.println(queryString);

        session.getTransaction().commit();
        factory.close();
    }
}
