package com.example.model.entities;

import java.util.Date;

import com.example.customvalidator.CheckNumberConstraint;
import com.example.model.enums.Author;
import com.example.model.enums.ThemeGeneral;
import com.example.model.enums.ThemeSub;
import com.example.model.enums.TypeOfTransaction;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
 

@Entity 
@Data
@Table(name = "account_records")
public class MyRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(nullable = false, unique = false)
    private Date dateOfTransaction;

    @Column(nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private TypeOfTransaction typeOfTransaction;

    @Column(nullable = true, unique = true)
    @CheckNumberConstraint
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