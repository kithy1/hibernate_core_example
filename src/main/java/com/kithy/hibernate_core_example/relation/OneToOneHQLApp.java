package com.kithy.hibernate_core_example.relation;

import com.kithy.hibernate_core_example.entity.Company;
import com.kithy.hibernate_core_example.entity.CompanyDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class OneToOneHQLApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        String select = "from Company";
        String select1 = "select c from Company c";
        String where = "select c from Company c join c.companyDetail cd where cd.employeeNumber > 15000";
        String sum = "select sum(c.value) from Company c join c.companyDetail cd where cd.residence='Poland' ";
        String lowEmployeeAmount = "select c.name from CompanyDetail cd join cd.company c " +
                "where cd.employeeNumber < 42355 order by c.name desc";

        session.beginTransaction();
        Query query = session.createQuery(lowEmployeeAmount);
        List<String> resultList = query.getResultList();
        //Long value = (Long)query.getSingleResult();

        session.getTransaction().commit();

        factory.close();
        resultList.forEach(company -> System.out.println(company));
        //System.out.println(value);
    }
}
