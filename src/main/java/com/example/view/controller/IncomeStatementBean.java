package com.example.view.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.entities.MyRecord;
import com.example.model.enums.Author;
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
    private List<Author> listOfSelectedAuthors = new ArrayList<>();

    private List<MyRecord> listForIncomeStatement;
    private List<Author> authors;

    @PostConstruct
    public void init(){
        setAuthorsNewArray();
        initList(selectedMonth,listOfSelectedAuthors);
        log.info("init 1 IncomeStatementBean -> {} ", selectedMonth);
        log.info("init 2 IncomeStatementBean listOfSelectedAuthors -> {} ", listOfSelectedAuthors);

    }

    public void initList(LocalDate firstDayOfTargetedMonth, List<Author> listOfSelectedAuthors){
        if (listOfSelectedAuthors != null  && !listOfSelectedAuthors.isEmpty()){
            listForIncomeStatement = repository.findMyRecordsByMonthAndAuthor(firstDayOfTargetedMonth,
                                                                            listOfSelectedAuthors,
                                                                            Arrays.asList(TypeOfTransaction.CASH, TypeOfTransaction.BALANCE));
        } else {
            listForIncomeStatement = repository.findDebitByMonth(firstDayOfTargetedMonth, Arrays.asList(TypeOfTransaction.CASH, 
                                                                                                    TypeOfTransaction.BALANCE));
        }
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
        initList(selectedMonth,listOfSelectedAuthors);
    }
    
    public void incrementMonth() {
        selectedMonth = selectedMonth.plusMonths(1);
        initList(selectedMonth,listOfSelectedAuthors);
    }

    public void setAuthorsNewArray(){
        authors = new ArrayList<>();
        authors.add(Author.BOTH);
        authors.add(Author.MURIEL);
        authors.add(Author.PATRICK);

    }
}
