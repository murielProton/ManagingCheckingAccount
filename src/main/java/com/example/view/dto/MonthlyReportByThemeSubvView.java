package com.example.view.dto;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.example.model.entities.MyRecord;
import com.example.model.enums.ThemeSub;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class MonthlyReportByThemeSubvView {

    public String month;
    public LocalDate targetedMonth;

    public Map<ThemeSub, Float> mapByThemeSub = new HashMap<>();
    

    public void addRecord(MyRecord curentRecord) {
        if(!curentRecord.isItSameMonth(targetedMonth)){
            return;
        }

        ThemeSub curentThemeG = curentRecord.getThemeSub();
        if(curentThemeG == null){
            curentThemeG =ThemeSub.NULL;

        }
        Float sum = mapByThemeSub.getOrDefault(curentThemeG, 0f);
        sum = Float.sum(sum, curentRecord.getAmount());
        mapByThemeSub.put(curentThemeG, sum);
    }
    //TODO ???
    public ThemeSub getThemeSub(){
        for ( ThemeSub key : mapByThemeSub.keySet() ) {
            return key;
        }
        return null;
    }
    public Float getSumDefault(){
        return mapByThemeSub.get(ThemeSub.NULL);
    }
    public Float getSumRent(){
        return mapByThemeSub.get(ThemeSub.RENT);
    }
    public Float getSumConstructionWork(){
        return  mapByThemeSub.get(ThemeSub.CONSTRUCTION_WORK);
    }
    public Float getSumCosts(){
        return  mapByThemeSub.get(ThemeSub.COSTS);
    }
    public Float getSumPropertyTaxes(){
        return  mapByThemeSub.get(ThemeSub.PROPERTY_TAXES);
    }
    public Float getSumWater(){
        return  mapByThemeSub.get(ThemeSub.WATER);
    }
    public Float getSumGass(){
        return  mapByThemeSub.get(ThemeSub.GASS);
    }
    public Float getSumElectricity(){
        return  mapByThemeSub.get(ThemeSub.ELECTRICITY);
    }
    public Float getSumLoan(){
        return mapByThemeSub.get(ThemeSub.LOAN);
    }
    public Float getSumFireWood(){
        return  mapByThemeSub.get(ThemeSub.FIRE_WOOD);
    }
    public Float getSumInsurance(){
        return  mapByThemeSub.get(ThemeSub.INSURANCE);
    }
    public Float getSumBoiler(){
        return  mapByThemeSub.get(ThemeSub.BOILER);
    }
    public Float getSumChimneySweeping(){
        return  mapByThemeSub.get(ThemeSub.CHIMNEY_SWEEPING);
    }
    public Float getSumHomeAppliance(){
        return  mapByThemeSub.get(ThemeSub.HOME_APPLIANCE);
    }
    public Float getSumFurniture(){
        return  mapByThemeSub.get(ThemeSub.FURNITURE);
    }
    public Float getInternetSubscription(){
        return  mapByThemeSub.get(ThemeSub.INTERNET_SUBSCRIPTION);
    }
    public Float getSumStreamingMediaSubscription(){
        return  mapByThemeSub.get(ThemeSub.STREAMING_MEDIA_SUBSCRIPTION);
    }
    public Float getTotal(){
        log.info("mapByThemeSub.size {}", mapByThemeSub.size());
        return (float) mapByThemeSub.values().stream().mapToDouble(Float::doubleValue).sum();
    }

}
