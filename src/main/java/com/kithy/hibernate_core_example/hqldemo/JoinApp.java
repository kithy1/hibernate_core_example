package com.kithy.hibernate_core_example.hqldemo;

import com.kithy.hibernate_core_example.entity.Company;
import com.kithy.hibernate_core_example.entity.CompanyDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class JoinApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        String join = "select c.name, c.value, c.companyDetail.residence, c.companyDetail.employeeNumber " +
                "from Company c join c.companyDetail";
        String join2 = "from Company as company join company.companyDetail as companyDetail";
        String join3 = "select c.name, cd.employeeNumber from Company c join CompanyDetail cd " +
                "on c.companyDetail.companyDetailId=cd.companyDetailId";
        Query query = session.createQuery(join3);
        List<Object[]> resultList = query.getResultList();
        for (Object[] objects : resultList) {
            for (int i = 0; i < objects.length; i++) {
                System.out.print(objects[i]);
                if(i<objects.length-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println(resultList.size());


        session.getTransaction().commit();

        factory.close();

    }
}
