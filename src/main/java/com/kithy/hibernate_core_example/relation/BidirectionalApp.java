package com.kithy.hibernate_core_example.relation;

import com.kithy.hibernate_core_example.entity.Company;
import com.kithy.hibernate_core_example.entity.CompanyDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BidirectionalApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

//        Company company = new Company("PZU", 1000000);
//        CompanyDetail companyDetail = new CompanyDetail("Poland",150);
//        companyDetail.setCompany(company);
//        company.setCompanyDetail(companyDetail);

        session.beginTransaction();

//        session.persist(companyDetail);
        CompanyDetail detail = session.get(CompanyDetail.class, 4);
        session.remove(detail);
//        System.out.println(detail.getCompany());


        session.getTransaction().commit();

        factory.close();
    }
}
