package com.example.model.entities;

import java.time.LocalDate;

import com.example.model.enums.BankAccount;
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

@ValidationRuleCheckNumber
@Entity 
@Data
public class MyRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = false)
    private LocalDate dateOfTransaction;

    @Column(nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private TypeOfTransaction typeTransaction;

    @Column(nullable = true, unique = true)
    private String checkNumber;

    @Column(nullable = false, unique = false)
    private String name;

    @Column(nullable = false, unique = false)
    private Float amount;

    @Column(nullable = true, unique = false)
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
    private BankAccount bankAccount;

    public Float getDisplayAmount(){
        if (!this.getTypeTransaction().isIncome()){
            return -1*this.getAmount();
        }
        return this.getAmount();
    }

    public boolean isItSameMonth(LocalDate targetedMonth){
        return this.getDateOfTransaction().getMonth() == targetedMonth.getMonth()
        && this.getDateOfTransaction().getYear() == targetedMonth.getYear();
    }
    public boolean isItOfSameThemeGeneral(ThemeGeneral themeGeneral){
        return this.getThemeGeneral() == themeGeneral;
    }
    public boolean isItSameThemeSub(ThemeSub themeSub){
        return this.getThemeSub() == themeSub;
    }

    
}