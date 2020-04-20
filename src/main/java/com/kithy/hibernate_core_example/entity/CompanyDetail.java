package com.kithy.hibernate_core_example.entity;

import javax.persistence.*;

@Entity
@Table(name = "company_detail")
public class CompanyDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company_detail")
    private Integer companyDetailId;
    @Column(name = "residence")
    private String residence;
    @Column(name = "employee_number")
    private Integer employeeNumber;
    @OneToOne(mappedBy = "companyDetail", cascade = CascadeType.ALL)
    private Company company;

    public CompanyDetail() {
    }

    public CompanyDetail(String residence, Integer employeeNumber) {
        this.residence = residence;
        this.employeeNumber = employeeNumber;
    }

    public Integer getCompanyDetailId() {
        return companyDetailId;
    }

    public void setCompanyDetailId(Integer companyDetailId) {
        this.companyDetailId = companyDetailId;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "CompanyDetail{" +
                "companyDetailId=" + companyDetailId +
                ", residence='" + residence + '\'' +
                ", employeeNumber=" + employeeNumber +
                '}';
    }
}
