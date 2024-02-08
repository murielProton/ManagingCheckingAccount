package com.example.view.dto;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.example.model.entities.MyRecord;
import com.example.model.enums.ThemeGeneral;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class MonthyReportView {

    public String month;
    public LocalDate targetedMonth;

    public Map<ThemeGeneral, Float> mapByThemeGeneral = new HashMap<>();
    

    public void addRecord(MyRecord curentRecord) {
        if(!curentRecord.isItSameMonth(targetedMonth)){
            return;
        }

        ThemeGeneral curentThemeG = curentRecord.getThemeGeneral();
        if(curentThemeG == null){
            curentThemeG =ThemeGeneral.NULL;

        }
        Float sum = mapByThemeGeneral.getOrDefault(curentThemeG, 0f);
        sum = Float.sum(sum, curentRecord.getAmount());
        mapByThemeGeneral.put(curentThemeG, sum);
    }
    public Float getSumDefault(){
        return mapByThemeGeneral.get(ThemeGeneral.NULL);
    }
    public Float getSumCaluireEtCuire(){
        return mapByThemeGeneral.get(ThemeGeneral.CALUIRE_ET_CUIRE);
    }
    public Float getSumMezieu(){ return  mapByThemeGeneral.get(ThemeGeneral.MEZIEU);}
    public Float getSumMontplat(){ return  mapByThemeGeneral.get(ThemeGeneral.MONTPLAT);}
    public Float getSumHealth(){ return  mapByThemeGeneral.get(ThemeGeneral.HEALTH);}
    public Float getSumFood(){ return  mapByThemeGeneral.get(ThemeGeneral.FOOD);}
    public Float getSumLeisure(){ return  mapByThemeGeneral.get(ThemeGeneral.LEISURE);}
    public Float getSumTravel(){ return  mapByThemeGeneral.get(ThemeGeneral.TRAVEL);}
    public Float getSumTCL(){ return  mapByThemeGeneral.get(ThemeGeneral.TCL);}
    public Float getSumClothing(){ return  mapByThemeGeneral.get(ThemeGeneral.CLOTHING);}
    public Float getSumStationary(){ return  mapByThemeGeneral.get(ThemeGeneral.STATIONARY);}
    public Float getSumOther(){ return  mapByThemeGeneral.get(ThemeGeneral.OTHER);}
    public Float getSumPresent(){ return  mapByThemeGeneral.get(ThemeGeneral.PRESENT);}
    public Float getSumIncomeTaxe(){ return  mapByThemeGeneral.get(ThemeGeneral.INCOME_TAXE);}
    public Float getSumTelephoneSubscription(){ return  mapByThemeGeneral.get(ThemeGeneral.TELEPHONE_SUBSCRIPTION);}

    public Float getTotal(){
        log.info("mapByThemeGeneral.size {}", mapByThemeGeneral.size());
        return (float) mapByThemeGeneral.values().stream().mapToDouble(Float::doubleValue).sum();
    }
}