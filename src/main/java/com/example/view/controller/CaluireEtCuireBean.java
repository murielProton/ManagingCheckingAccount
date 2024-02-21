package com.example.view.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.entities.MyRecord;
import com.example.model.enums.ThemeSub;
import com.example.model.enums.TypeOfTransaction;
import com.example.repository.MyRecordRepository;
import com.example.view.dto.CaluireCuireView;

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

public class CaluireEtCuireBean extends UtilsBean  implements Serializable {
    @Autowired
    private MyRecordRepository repository;
    private LocalDate selectedYear = LocalDate.of(LocalDate.now().getYear(), 1, 1);
    private List<MyRecord> listOfMyRecors;

    private List<String> monthList = UtilsBean.listOfMonth();

    private List<MyRecord> listForYearlyTransactions;
    private List<ThemeSub> listOfAllThemeSub;
    private List<ThemeSub> listOfThemeSubForCaluireEtCuire;

    private List<CaluireCuireView> listOfCaluireCuireView;

    @PostConstruct
    public void init() {
        listOfThemeSubForCaluireEtCuire = repository.findThemeSubsForCaluireEtCuire(
                                                            Arrays.asList(ThemeSub.FIRE_WOOD,
                                                                            ThemeSub.FURNITURE,
                                                                            ThemeSub.INTERNET_SUBSCRIPTION,
                                                                            ThemeSub.LOAN));
        initList();
        log.info("init 1 IncomeStatementBean -> {} ", selectedYear);
    }

    public void save() {
        initList();
    }

    public void initList() {
        listForYearlyTransactions = repository.findDebitByYear(selectedYear,
                Arrays.asList(TypeOfTransaction.BALANCE));
        setMapAmountMonthAndThemeSub();
    }
// TODO factorise in UtilsBean
    public void decrementYear() {
        selectedYear = selectedYear.minusYears(1);
        log.info("New year {}", selectedYear);
        initList();
    }
// TODO Factorise in UtilsBean
    public void incrementYear() {
        selectedYear = selectedYear.plusYears(1);
        log.info("New year {}", selectedYear);
        initList();
    }

    public void setMapAmountMonthAndThemeSub() {
        listOfCaluireCuireView = new ArrayList<>();
        for (Integer i = 0; i < 12; i++) {
            String currentMonth = monthList.get(i);
            LocalDate targetedMonth = LocalDate.of(selectedYear.getYear(), i + 1, 1);
            CaluireCuireView caluireCuireView = new CaluireCuireView();

            caluireCuireView.setMonth(currentMonth);
            caluireCuireView.setTargetedMonth(targetedMonth);
            for (MyRecord curentRecord : listForYearlyTransactions) {
                caluireCuireView.addRecord(curentRecord);
            }
            listOfCaluireCuireView.add(caluireCuireView);
        }
    }

    public Float getSumOf(ThemeSub theme) {
        Float result = 0f;
        for (CaluireCuireView report : listOfCaluireCuireView) {
            Float toAdd = report.getMapByThemeSub().get(theme);
           // ThemeSub key = report.getThemeSub();
            if(toAdd != null){
                result += toAdd;
               /* TODO if (key.equals(ThemeSub.RENT)) {
                    // If the key is RENT, add the value to the result
                    result += toAdd;
                } else {
                    // For other keys, subtract the value from the result
                    result -= toAdd;
                }*/
            }
        }
        log.info("getSumOf(ThemeSub theme) -> {} ", result);
        return result;
    }
// TODO realy get a total of revenues when income + || if not -
    public Float getSumDefault() {
        return getSumOf(ThemeSub.NULL);
    }

    public Float getSumBoiler() {
        return getSumOf(ThemeSub.BOILER);
    }
    public Float getSumConstructionWork(){ return  getSumOf(ThemeSub.CONSTRUCTION_WORK);}
    public Float getSumCosts(){ return  getSumOf(ThemeSub.COSTS);}
    public Float getSumElectricity(){ return  getSumOf(ThemeSub.ELECTRICITY);}
    public Float getSumGass(){ return  getSumOf(ThemeSub.GASS);}
    public Float getSumHomeAppliance(){ return  getSumOf(ThemeSub.HOME_APPLIANCE);}
    public Float getSumInsurance(){ return  getSumOf(ThemeSub.INSURANCE);}
    public Float getSumPropertyTaxes(){ return  getSumOf(ThemeSub.PROPERTY_TAXES);}
    public Float getSumRent(){ return  getSumOf(ThemeSub.RENT);}
    public Float getSumWater(){ return  getSumOf(ThemeSub.WATER);}



    // calculate averages

    public Float getAverageDefault() {
        return getSumOf(ThemeSub.NULL)/12;
    }

    public Float getAverageBoiler() {
        return getSumOf(ThemeSub.BOILER)/12;
    }
    public Float getAverageConstructionWork(){ return  getSumOf(ThemeSub.CONSTRUCTION_WORK)/12;}
    public Float getAverageCosts(){ return  getSumOf(ThemeSub.COSTS)/12;}
    public Float getAverageElectricity(){ return  getSumOf(ThemeSub.ELECTRICITY)/12;}
    public Float getAverageGass(){ return  getSumOf(ThemeSub.GASS)/12;}
    public Float getAverageHomeAppliance(){ return  getSumOf(ThemeSub.HOME_APPLIANCE)/12;}
    public Float getAverageInsurance(){ return  getSumOf(ThemeSub.INSURANCE)/12;}
    public Float getAveragePropertyTaxes(){ return  getSumOf(ThemeSub.PROPERTY_TAXES)/12;}
    public Float getAverageRent(){ return  getSumOf(ThemeSub.RENT)/12;}
    public Float getAverageWater(){ return  getSumOf(ThemeSub.WATER)/12;}
}
