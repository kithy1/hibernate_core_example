package com.kithy.hibernate_core_example.relation;

import com.kithy.hibernate_core_example.entity.Company;
import com.kithy.hibernate_core_example.entity.CompanyDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CascadeRemoveApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Company company = session.get(Company.class, 1);
        session.remove(company);

        session.getTransaction().commit();

        factory.close();
    }
}
