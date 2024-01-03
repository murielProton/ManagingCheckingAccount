package com.example.model.entities;

import java.util.Date;

import com.example.model.enums.Author;
import com.example.model.enums.ThemeGeneral;
import com.example.model.enums.ThemeSub;
import com.example.model.enums.TypeOfTransaction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity 
@Data
public class MyRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // WARNING Date Type is depreciated since java 8
    @Column(nullable = false, unique = false)
    private Date dateOfTransaction;

    @Column(nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private TypeOfTransaction typeTransaction;

    @Column(nullable = true, unique = true)
    private String checkNumber;

    @Column(nullable = false, unique = false)
    private String name;

    @Column(nullable = false, unique = false)
    private Float amount;

    @Column(nullable = false, unique = false)
     @Enumerated(EnumType.STRING)
    private ThemeGeneral themeGeneral;

    @Column(nullable = true, unique = false)
    private String beneficiary;
    
    @Column(nullable = true, unique = false)
    @Enumerated(EnumType.STRING)
    private ThemeSub themeSub;

    @Column(nullable = true, unique = false)
    private String tenant;

    @Column(nullable = true, unique = false)
    @Enumerated(EnumType.STRING)
    private Author author;

}