package com.kithy.hibernate_core_example.hqldemo;

import com.kithy.hibernate_core_example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class NamedParametersApp {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String employeeFirstName = "Steven";
        String employeeLastName = "King";
        String namedParameterString = "select e.firstName, e.lastName, e.salary from Employee e " +
                "where e.firstName=:fname and e.lastName=:lname";
        Query namedParameterQuery = session.createQuery(namedParameterString);
        namedParameterQuery.setParameter("fname", employeeFirstName);
        namedParameterQuery.setParameter("lname", employeeLastName);
        List<Object[]> resultList = namedParameterQuery.getResultList();
        session.getTransaction().commit();
        factory.close();
        for (Object[] objects : resultList) {
            System.out.println(objects[0] + " " + objects[1] + " " + objects[2]);
        }
    }
}
