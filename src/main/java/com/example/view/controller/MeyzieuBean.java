package com.example.view.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.model.entities.MyRecord;
import com.example.model.enums.ThemeGeneral;
import com.example.model.enums.ThemeSub;
import com.example.model.enums.TypeOfTransaction;

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
public class MeyzieuBean extends AbstractRepportByThemeSubBean  implements Serializable {
    private List<ThemeSub> listOfThemeSubForMeyzieu;
    private List<MyRecord> listMyRecord;

    @PostConstruct
    public void init() {
        listOfThemeSubForMeyzieu = getRepository().findDistinctThemeSubsFrom(
                                                            Arrays.asList(ThemeSub.RENT));
        super.init();
        log.info("init 1 MeyzieuBean -> {} ", getSelectedYear());
    }

    public  void initListMyRecord(){
        listMyRecord = getRepository().findYearlyReportsByThemeGeneral(getSelectedYear(),
                                                                        ThemeGeneral.MEZIEU,
                                                                        Arrays.asList(TypeOfTransaction.BALANCE));
    }
}
