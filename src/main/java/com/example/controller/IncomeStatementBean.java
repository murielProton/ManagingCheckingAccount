package com.example.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private LocalDate initDate = LocalDate.now().withDayOfMonth(1);

    private List<MyRecord> listForIncomeStatement;

    @PostConstruct
    public void init(){
        listForIncomeStatement = findAllBut(initDate);
        log.info("init 1 IncomeStatementBean -> {} ", initDate);
    }
    public void save(){
        listForIncomeStatement = findAllBut(initDate);
    }

    public List<MyRecord> findAllBut(LocalDate firstDayOfTargetedMonth){
        List<MyRecord> listOfMyRecordToFilter = repository.findAll();
        List<MyRecord> listOfMyRecordFiltered1 = findByMonth(listOfMyRecordToFilter, firstDayOfTargetedMonth);
        //getOldBalance(listOfMyRecordFiltered1);
        List<MyRecord> listOfMyRecordFiltered2 = findTheRightTypeOfTransaction(listOfMyRecordFiltered1);
        List<MyRecord> listOfMyRecordFiltered3 = changeAmountValue(listOfMyRecordFiltered2);
        return listOfMyRecordFiltered3;

    }
    public List<MyRecord> findByMonth(List<MyRecord> listOfMyRecordToFilter, LocalDate firstDayOfTargetedMonth){
        LocalDate startDate = firstDayOfTargetedMonth.withDayOfMonth(1);
        LocalDate endDate = firstDayOfTargetedMonth.withDayOfMonth(initDate.lengthOfMonth());
        List<MyRecord> listOfMyRecordOfMonth = new ArrayList<>();
        log.info("findByMonth -> {} ",startDate);
        log.info("findByMonth -> {} ",endDate);
        if(listOfMyRecordToFilter == null){
            return null;
        }
        for (MyRecord curentRecord : listOfMyRecordToFilter) {
            if (!curentRecord.getDateOfTransaction().isBefore(startDate)
                    && !curentRecord.getDateOfTransaction().isAfter(endDate)){
                listOfMyRecordOfMonth.add(curentRecord);
                log.info("findByMonth for if-> {} ", curentRecord);
            }
        }
        return listOfMyRecordOfMonth;
    }
    public List<MyRecord> findTheRightTypeOfTransaction(List<MyRecord> listOfMyRecordToFilter){
        List<MyRecord> listOfMyRecords = new ArrayList<>();
        if(listOfMyRecordToFilter == null){
            return null;
        }
        for (MyRecord curentRecord : listOfMyRecordToFilter) {
            if (curentRecord.getTypeTransaction() != TypeOfTransaction.CASH &&
                    curentRecord.getTypeTransaction() != TypeOfTransaction.BALANCE){
                listOfMyRecords.add(curentRecord);
                log.info("findTheRightTypeOfTransaction for if-> {} ", curentRecord.getTypeTransaction());
            }
        }
        return listOfMyRecords;
    }
    public List<MyRecord> changeAmountValue(List<MyRecord> listOfMyRecordToFilter){
        if(listOfMyRecordToFilter == null){
            return null;
        }
        for (MyRecord curentRecord : listOfMyRecordToFilter) {
            if (!curentRecord.getTypeTransaction().isIncome()){
                curentRecord.setAmount(curentRecord.getAmount()*-1);
                log.info("changeAmountValue for if-> {} ", curentRecord.getAmount());
            }
        }
        return listOfMyRecordToFilter;
    }

    public Float getTotalCredit(){
        return  listForIncomeStatement.stream()
            .filter(s -> s.getAmount()> 0)
            .map(s -> s.getAmount())
            .reduce(0f, (a, b) -> a + b);
    }
    public Float getTotalDebit(){
        return  listForIncomeStatement.stream()
            .filter(s -> s.getAmount()<0)
            .map(s -> s.getAmount())
            .reduce(0f, (a, b) -> a + b);
    }

    /*
    TODO 
    public Float getOldBalance(List<MyRecord> monthlyListForIncomeStatement){
        if (monthlyListForIncomeStatement!=null){
            for (MyRecord curentRecord : monthlyListForIncomeStatement) {
                if (curentRecord.getTypeTransaction() == TypeOfTransaction.BALANCE){
                    return curentRecord.getAmount()f;
                }
            }
        }else{
            return 0f;
        }
    }
    public Float getNewBalance(){
        return  getOldBalance() + getTotalCredit() + getTotalDebit();
    }*/
}
