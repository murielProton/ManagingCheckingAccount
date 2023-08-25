package com.example.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MyRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = false)
    private Date dateOfTransaction;

    @Column(nullable = true, unique = false)
    private String typeTransaction;

    @Column(nullable = true, unique = false)
    private String name;

    @Column(nullable = false, unique = false)
    private Float amount;

    @Column(nullable = true, unique = false)
    private String theme;

    @Column(nullable = true, unique = false)
    private String author;

}