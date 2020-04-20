package com.kithy.hibernate_core_example.entity;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company")
    private Integer companyId;
    @Column(name = "name")
    private String name;
    @Column(name = "value")
    private Integer value;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "id_company_detail") // nazwa kolumny w której przechowywane są klucze obce
    private CompanyDetail companyDetail;

    public Company() {
    }

    public Company(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public CompanyDetail getCompanyDetail() {
        return companyDetail;
    }

    public void setCompanyDetail(CompanyDetail companyDetail) {
        this.companyDetail = companyDetail;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
