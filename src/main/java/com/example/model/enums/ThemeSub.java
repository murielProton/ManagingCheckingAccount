package com.example.model.enums;

import static com.example.model.enums.ThemeGeneral.*;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

        /** The field 'Author' appears if ThemeSub value is in the folowing list : CONSTRUCTION_WORK, COSTS, PROPERTY_TAXES, WATER, GASS, 
         * ELECTRICITY, LOAN, FIRE_WOOD, INSURANCE, BOILER, CHIMNEY_SWEEPING, HOME_APPLIANCE, FURNITURE.\
         * **/
public enum ThemeSub {
    NULL("", Arrays.asList(ThemeGeneral.values()), true, false),
    RENT("Loyer", Arrays.asList(CALUIRE_ET_CUIRE), false, true),
    CONSTRUCTION_WORK("Travaux",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU), false, false),
    COSTS("Coût",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU), true, false),
    PROPERTY_TAXES("Taxe foncière",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU), true, false),
    WATER("Eau",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU), true, false),
    GASS("Gaz",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU), true, false),
    ELECTRICITY("Electircité",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU), true, false),
    LOAN("Prêt",Arrays.asList(MEZIEU), true, false),
    FIRE_WOOD("Bois de chauffe",Arrays.asList(MEZIEU), true, false),
    INSURANCE("Assurance",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU,TRAVEL, OTHER), true, false),
    BOILER("Chaudière",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU), true, false),
    CHIMNEY_SWEEPING("Ramonage",Arrays.asList(MONTPLAT, MEZIEU), true, false),
    HOME_APPLIANCE("Electroménager",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU), true, false),
    FURNITURE("Mobilier",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU, MONTPLAT), true, false),
    INTERNET_SUBSCRIPTION("Abonnement à Internet",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU), true, false),
    STREAMING_MEDIA_SUBSCRIPTION("Abonnement à une plateforme de streaming",Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU), true, false)
    ;

    private @Getter String name;
    private @Getter List<ThemeGeneral> listGenerals;
    private @Getter boolean authorRendered;
    private @Getter boolean tenantRendered;

    private ThemeSub(String name, List<ThemeGeneral> list, boolean authorRendered, boolean tenantRendered){
        this.name = name;
        this.listGenerals = list;
        this.authorRendered = authorRendered;
        this.tenantRendered = tenantRendered;

    }
}
