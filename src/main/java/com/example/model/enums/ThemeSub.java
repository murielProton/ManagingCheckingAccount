package com.example.model.enums;

import static com.example.model.enums.ThemeGeneral.*;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;


public enum ThemeSub {
    NULL("", Arrays.asList(ThemeGeneral.values())),
    RENT("Loyer", Arrays.asList(CALUIRE_ET_CUIRE)),
    CONSTRUCTION_WORK("Travaux",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU)),
    COSTS("Coût",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU)),
    PROPERTY_TAXES("Taxe foncière",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU)),
    WATER("Eau",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU)),
    GASS("Gaz",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU)),
    ELECTRICITY("Electircité",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU)),
    LOAN("Prêt",Arrays.asList(MEZIEU)),
    FIRE_WOOD("Bois de chauffe",Arrays.asList(MEZIEU)),
    INSURANCE("Assurance",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU)),
    BOILER("Chaudière",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU)),
    CHIMNEY_SWEEPING("Ramonage",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU)),
    HOME_APPLIANCE("Electroménager",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU)),
    FURNITURE("Mobilier",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU, MONTPLAT)),
    PATRICK("Patrick",Arrays.asList(CLOTHING, LEISURE,HEALTH,TCL,STATIONARY,INCOME_TAXE)),
    MURIEL("Muriel",Arrays.asList(CLOTHING, LEISURE, HEALTH,TCL,STATIONARY,INCOME_TAXE));

    private @Getter String name;
    private @Getter List<ThemeGeneral> listGenerals;

    private ThemeSub(String name, List<ThemeGeneral> list){
        this.name= name;
        this.listGenerals = list;
    }
}
