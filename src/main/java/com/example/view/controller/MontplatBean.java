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
public class MontplatBean extends AbstractRepportByThemeSubBean  implements Serializable {
    private List<ThemeSub> listOfThemeSubForMontplat;
    private List<MyRecord> listMyRecord;

    @PostConstruct
    public void init() {
        listOfThemeSubForMontplat = getRepository().findDistinctThemeSubsFrom(
                                                            Arrays.asList(ThemeSub.ELECTRICITY,
                                                                            ThemeSub.FURNITURE,
                                                                            ThemeSub.INTERNET_SUBSCRIPTION,
                                                                            ThemeSub.STREAMING_MEDIA_SUBSCRIPTION,
                                                                            ThemeSub.RENT,
                                                                            ThemeSub.LOAN));
        super.init();
        log.info("init 1 MontplatBean -> {} ", getSelectedYear());
    }

    public  void initListMyRecord(){
        listMyRecord = getRepository().findYearlyReportsByThemeGeneral(getSelectedYear(),
                                                                        ThemeGeneral.MONTPLAT,
                                                                        Arrays.asList(TypeOfTransaction.BALANCE));
    }
}
