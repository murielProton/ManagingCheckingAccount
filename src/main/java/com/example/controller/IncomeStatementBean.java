package com.example.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.entities.MyRecord;
import com.example.model.enums.TypeOfTransaction;
import com.example.repository.MyRecordRepository;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Component
@Named
@ViewScoped
@Slf4j
@Getter
@Setter
public class IncomeStatementBean extends UtilsBean  implements Serializable {
    @Autowired
    private MyRecordRepository repository;
    private LocalDate selectedMonth = LocalDate.now().withDayOfMonth(1);
     // TODO add a form to the front so the user can choose witch month. This should be the default value.

    private List<MyRecord> listForIncomeStatement;

    @PostConstruct
    public void init(){
        listForIncomeStatement = initList(selectedMonth);
        log.info("init 1 IncomeStatementBean -> {} ", selectedMonth);
    }
    public void save(){
        listForIncomeStatement = initList(selectedMonth);
    }

    public List<MyRecord> initList(LocalDate firstDayOfTargetedMonth){
        return repository.findByMonth(firstDayOfTargetedMonth, Arrays.asList(TypeOfTransaction.CASH, TypeOfTransaction.BALANCE));
    }

    public Float getTotalCredit(){
        return  listForIncomeStatement.stream()
            .filter(s -> s.getDisplayAmount()> 0)
            .map(s -> s.getDisplayAmount())
            .reduce(0f, (a, b) -> a + b);
    }
    public Float getTotalDebit(){
        return  listForIncomeStatement.stream()
            .filter(s -> s.getDisplayAmount()<0)
            .map(s -> s.getDisplayAmount())
            .reduce(0f, (a, b) -> a + b);
    }

    public Float getOldBalance(){
        MyRecord balanceRecord = repository.findBalanceByMonth(selectedMonth);
        if(balanceRecord == null){
            return (float) 0;
        }
        return balanceRecord.getDisplayAmount();
    }

    public Float getNewBalance(){
        return getOldBalance() + getTotalCredit() + getTotalDebit();
    }

    public void decrementMonth() {  
        selectedMonth = selectedMonth.minusMonths(1);
        initList(selectedMonth);
    }  
    
    public void incrementMonth() {
        selectedMonth = selectedMonth.plusMonths(1);
        initList(selectedMonth);
    }
}
