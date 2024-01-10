package com.example.model.enums;

import static com.example.model.enums.ThemeGeneral.*;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

        /** The field 'Author' appears if ThemeSub value is in the folowing list : CONSTRUCTION_WORK, COSTS, PROPERTY_TAXES, WATER, GASS, 
         * ELECTRICITY, LOAN, FIRE_WOOD, INSURANCE, BOILER, CHIMNEY_SWEEPING, HOME_APPLIANCE, FURNITURE.\
         * **/
public enum ThemeSub {
    NULL("", Arrays.asList(ThemeGeneral.values()), true),
    RENT("Loyer", Arrays.asList(CALUIRE_ET_CUIRE), true),
    CONSTRUCTION_WORK("Travaux",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU), false),
    COSTS("Coût",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU), false),
    PROPERTY_TAXES("Taxe foncière",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU), false),
    WATER("Eau",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU), false),
    GASS("Gaz",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU), false),
    ELECTRICITY("Electircité",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU), false),
    LOAN("Prêt",Arrays.asList(MEZIEU), false),
    FIRE_WOOD("Bois de chauffe",Arrays.asList(MEZIEU), false),
    INSURANCE("Assurance",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU), false),
    BOILER("Chaudière",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU), false),
    CHIMNEY_SWEEPING("Ramonage",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU), false),
    HOME_APPLIANCE("Electroménager",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU), false),
    FURNITURE("Mobilier",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU, MONTPLAT), false),
    PATRICK("Patrick",Arrays.asList(CLOTHING, LEISURE,HEALTH,TCL,STATIONARY,INCOME_TAXE), false),
    MURIEL("Muriel",Arrays.asList(CLOTHING, LEISURE, HEALTH,TCL,STATIONARY,INCOME_TAXE), false);

    private @Getter String name;
    private @Getter List<ThemeGeneral> listGenerals;
       private @Getter boolean authorHide;

    private ThemeSub(String name, List<ThemeGeneral> list, boolean authorHide){
        this.name = name;
        this.listGenerals = list;
        this.authorHide = authorHide;
    }
}
