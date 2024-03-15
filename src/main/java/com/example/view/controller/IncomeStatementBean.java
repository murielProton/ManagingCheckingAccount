package com.example.view.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.entities.MyRecord;
import com.example.model.enums.BankAccount;
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
    private List<BankAccount> listOfSelectedBankAccounts = new ArrayList<>();

    private List<MyRecord> listForIncomeStatement;
    private List<BankAccount> bankAccounts;

    @PostConstruct
    public void init(){
        setBankAccountsNewArray();
        initList(selectedMonth,listOfSelectedBankAccounts);
        log.info("init 1 IncomeStatementBean -> {} ", selectedMonth);
        log.info("init 2 IncomeStatementBean listOfSelectedBankAccounts -> {} ", listOfSelectedBankAccounts);

    }

    public void initList(LocalDate selectedMonth, List<BankAccount> listOfSelectedBankAccounts){
        if (listOfSelectedBankAccounts != null  && !listOfSelectedBankAccounts.isEmpty()){
            listForIncomeStatement = repository.findMyRecordsByMonthAndBankAccounts(selectedMonth,
                                                                            listOfSelectedBankAccounts,
                                                                            Arrays.asList(TypeOfTransaction.CASH, TypeOfTransaction.BALANCE));
        } else {
            listForIncomeStatement = repository.findDebitByMonth(selectedMonth, Arrays.asList(TypeOfTransaction.CASH, 
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
        log.info("decrementMonth -> {} ", selectedMonth);
        initList(selectedMonth,listOfSelectedBankAccounts);
    }
    
    public void incrementMonth() {
        selectedMonth = selectedMonth.plusMonths(1);
        log.info("incrementMonth -> {} ", selectedMonth);
        initList(selectedMonth,listOfSelectedBankAccounts);
    }

    public void setBankAccountsNewArray(){
        bankAccounts = new ArrayList<>();
        bankAccounts.add(BankAccount.JOINT);
        bankAccounts.add(BankAccount.MURIEL_CURRENT_ACCOUNT);
        bankAccounts.add(BankAccount.PATRICK_CURRENT_ACCOUNT);
        bankAccounts.add(BankAccount.MURIEL_SAVING_ACCOUNT);


    }
}
