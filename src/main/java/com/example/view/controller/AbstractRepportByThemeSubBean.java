package com.example.view.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.entities.MyRecord;
import com.example.model.enums.ThemeSub;
import com.example.repository.MyRecordRepository;
import com.example.view.dto.MonthlyReportByThemeSubvView;

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

public abstract class AbstractRepportByThemeSubBean extends UtilsBean  implements Serializable {
    @Autowired
    private MyRecordRepository repository;
    private LocalDate selectedYear = LocalDate.of(LocalDate.now().getYear(), 1, 1);

    private List<String> monthList = UtilsBean.listOfMonth();

    public abstract List<MyRecord> getListMyRecord();
    public abstract void initListMyRecord();

    private List<MonthlyReportByThemeSubvView> listOfReportByThemeSubView;

    @PostConstruct
    public void init() {
        initList();
    }

    public void initList() {
        initListMyRecord();
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
        listOfReportByThemeSubView = new ArrayList<>();
        for (Integer i = 0; i < 12; i++) {
            String currentMonth = monthList.get(i);
            LocalDate targetedMonth = LocalDate.of(selectedYear.getYear(), i + 1, 1);
            MonthlyReportByThemeSubvView reportByThemeView = new MonthlyReportByThemeSubvView();

            reportByThemeView.setMonth(currentMonth);
            reportByThemeView.setTargetedMonth(targetedMonth);
            for (MyRecord curentRecord : getListMyRecord()) {
                reportByThemeView.addRecord(curentRecord);
            }
            listOfReportByThemeSubView.add(reportByThemeView);
        }
    }

    public Float getSumOf(ThemeSub theme) {
        Float result = 0f;
        for (MonthlyReportByThemeSubvView report : listOfReportByThemeSubView) {
            Float toAdd = report.getMapByThemeSub().get(theme);
            if(toAdd != null){
                result += toAdd;
            }
        }
        log.info("getSumOf(ThemeSub theme) -> {} ", result);
        return result;
    }
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
