package com.example.view.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.entities.MyRecord;
import com.example.model.enums.ThemeGeneral;
import com.example.model.enums.TypeOfTransaction;
import com.example.repository.MyRecordRepository;
import com.example.view.dto.MonthyReportView;

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
public class YearlyExpensesBean extends UtilsBean implements Serializable {
    @Autowired
    private MyRecordRepository repository;
    private LocalDate selectedYear = LocalDate.of(LocalDate.now().getYear(), 1, 1);
    private List<MyRecord> listOfMyRecors;

    private List<String> monthList = UtilsBean.listOfMonth();

    private List<MyRecord> listForYearlyExpenses;
    private List<ThemeGeneral> listOfAllThemeGeneral;

    private List<MonthyReportView> listMonthlyReportView;

    @PostConstruct
    public void init() {
        listOfAllThemeGeneral = repository.findAllDistinctThemeGenerals();
        initList();
        log.info("init 1 IncomeStatementBean -> {} ", selectedYear);
    }

    public void save() {
        initList();
    }

    public void initList() {
        listForYearlyExpenses = repository.findDebitByYear(selectedYear,
                Arrays.asList(TypeOfTransaction.SALARY, TypeOfTransaction.BALANCE, TypeOfTransaction.CASHING,
                        TypeOfTransaction.CHECK_CASHING, TypeOfTransaction.PAYMENT));
        setMapAmountMonthAndTheme();
    }

    public void decrementYear() {
        selectedYear = selectedYear.minusYears(1);
        log.info("New year {}", selectedYear);
        initList();
    }

    public void incrementYear() {
        selectedYear = selectedYear.plusYears(1);
        log.info("New year {}", selectedYear);
        initList();
    }

    public void setMapAmountMonthAndTheme() {
        listMonthlyReportView = new ArrayList<>();
        for (Integer i = 0; i < 12; i++) {
            String currentMonth = monthList.get(i);
            LocalDate targetedMonth = LocalDate.of(selectedYear.getYear(), i + 1, 1);
            MonthyReportView monthlyReportView = new MonthyReportView();

            monthlyReportView.setMonth(currentMonth);
            monthlyReportView.setTargetedMonth(targetedMonth);
            for (MyRecord curentRecord : listForYearlyExpenses) {
                monthlyReportView.addRecord(curentRecord);
            }
            listMonthlyReportView.add(monthlyReportView);
        }
    }

    public Float getSumOf(ThemeGeneral theme) {
        Float result = 0f;
        for (MonthyReportView report : listMonthlyReportView) {
            Float toAdd = report.getMapByThemeGeneral().get(theme);
            if(toAdd != null){
                result += toAdd;
            }
        }
        return result;
    }

    public Float getSumDefault() {
        return getSumOf(ThemeGeneral.NULL);
    }

    public Float getSumCaluireEtCuire() {
        return getSumOf(ThemeGeneral.CALUIRE_ET_CUIRE);
    }
    public Float getSumMezieu(){ return  getSumOf(ThemeGeneral.MEZIEU);}
    public Float getSumMontplat(){ return  getSumOf(ThemeGeneral.MONTPLAT);}
    public Float getSumHealth(){ return  getSumOf(ThemeGeneral.HEALTH);}
    public Float getSumFood(){ return  getSumOf(ThemeGeneral.FOOD);}
    public Float getSumLeisure(){ return  getSumOf(ThemeGeneral.LEISURE);}
    public Float getSumTravel(){ return  getSumOf(ThemeGeneral.TRAVEL);}
    public Float getSumTCL(){ return  getSumOf(ThemeGeneral.TCL);}
    public Float getSumClothing(){ return  getSumOf(ThemeGeneral.CLOTHING);}
    public Float getSumStationary(){ return  getSumOf(ThemeGeneral.STATIONARY);}
    public Float getSumOther(){ return  getSumOf(ThemeGeneral.OTHER);}
    public Float getSumPresent(){ return  getSumOf(ThemeGeneral.PRESENT);}
    public Float getSumIncomeTaxe(){ return  getSumOf(ThemeGeneral.INCOME_TAXE);}
    public Float getSumTelephoneSubscription(){ return  getSumOf(ThemeGeneral.TELEPHONE_SUBSCRIPTION);}
    // TODO calculate Moyenne and Summ for the month

}