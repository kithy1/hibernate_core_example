package com.kithy.hibernate_core_example.entity;

import javax.persistence.*;

@Entity
@Table(name = "book", schema = "dbo")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;
    @Column(name = "book_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
