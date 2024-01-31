package com.example.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.entities.MyRecord;
import com.example.model.enums.ThemeGeneral;
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
public class YearlyExpensesBean extends UtilsBean  implements Serializable {
    @Autowired
    private MyRecordRepository repository;
    private LocalDate selectedYear = LocalDate.of(LocalDate.now().getYear(), 1, 1);
    private List<MyRecord> listOfMyRecors;

    private List<String> monthList = Arrays.asList("Janvier",
                                                        "Février",
                                                        "Mars",
                                                        "Avril",
                                                        "Mai",
                                                        "Juin",
                                                        "Juillet",
                                                        "Août",
                                                        "Septembre",
                                                        "Octobre",
                                                        "Novembre",
                                                        "Décembre",
                                                        "TOTAL",
                                                        "MOYENNE");

    private List<MyRecord> listForYearlyExpenses;
    private List<ThemeGeneral> listOfAllThemeGeneral; 

    private Map<String, Map<ThemeGeneral, Float>> mapByMounthThenByThemeGeneral = new HashMap<>();

    @PostConstruct
    public void init(){
        listOfAllThemeGeneral= repository.findAllDistinctThemeGenerals();
        initList();
        log.info("init 1 IncomeStatementBean -> {} ", selectedYear);
    }
    public void save(){
        initList();
    }
    public void initList(){
        listForYearlyExpenses = repository.findDebitByYear(selectedYear,  Arrays.asList(TypeOfTransaction.SALARY, TypeOfTransaction.BALANCE, TypeOfTransaction.CASHING, TypeOfTransaction.CHECK_CASHING, TypeOfTransaction.PAYMENT));
        setMapAmountMonthAndTheme();
    }
    public void decrementYear() {
        selectedYear = selectedYear.minusYears(1);
        log.info("New year {}",selectedYear);
        initList();
    }
    
    public void incrementYear() {
        selectedYear = selectedYear.plusYears(1);
        log.info("New year {}",selectedYear);
        initList();
    }
    public void setMapAmountMonthAndTheme(){
        for(Integer i = 0; i < 12 ; i++){
            String currentMonth = monthList.get(i);
            LocalDate targetedMonth = LocalDate.of(selectedYear.getYear(), i+1, 1);

            Map<ThemeGeneral, Float> mapByThemeGeneral = mapByMounthThenByThemeGeneral.get(currentMonth);
            if(mapByThemeGeneral == null){
                mapByThemeGeneral = new HashMap<>();
            }
            mapByMounthThenByThemeGeneral.put(currentMonth, mapByThemeGeneral);

            for(ThemeGeneral curentThemeGeneral: listOfAllThemeGeneral){
                Float sum = Float.valueOf(0);
                for (MyRecord curentRecord : listForYearlyExpenses) {
                    if(curentRecord.isItSameMonth(targetedMonth) && curentRecord.isItOfSameThemeGeneral(curentThemeGeneral)){
                        sum = Float.sum(sum, curentRecord.getAmount());
                        
                    }
                }
                log.info(" ajout {} {}", curentThemeGeneral, sum);
                mapByThemeGeneral.put(curentThemeGeneral, sum);
            }
        }
    }

}