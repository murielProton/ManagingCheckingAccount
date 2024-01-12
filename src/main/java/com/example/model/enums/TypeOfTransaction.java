package com.example.model.enums;

import static com.example.model.enums.ThemeGeneral.*;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

        /** The field 'Check Number' appears if TypeOfTransaction value is CHECK.\
         * **/

public enum TypeOfTransaction {
    SALARY("Salaire", true, false, false, Arrays.asList(NULL)),
    PAYMENT("Virement", true, false, true, Arrays.asList(CALUIRE_ET_CUIRE, OTHER)),
    TIP("TIP", false, false, true, Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU,TELEPHONE_SUBSCRIPTION,INCOME_TAXE)),
    AUTOMATIC_DRAWDOWN("Prélèvement automatique",false, false, true, Arrays.asList(CALUIRE_ET_CUIRE, MEZIEU,TELEPHONE_SUBSCRIPTION,INCOME_TAXE)),
    WITHDRAWAL("Retrait", false, false, false, Arrays.asList(NULL)),
    CREDIT_CARD("CB", false, false, true, Arrays.asList(CALUIRE_ET_CUIRE,CLOTHING, FOOD, HEALTH, INCOME_TAXE, LEISURE, MEZIEU, MONTPLAT, NULL, OTHER, PRESENT, STATIONARY, TCL, TELEPHONE_SUBSCRIPTION, TRAVEL)),
    CHECK_CASHING("Encaissement de chèque", true, false, true, Arrays.asList(CALUIRE_ET_CUIRE, OTHER)),
    CASHING("Encaissement", true, false, true, Arrays.asList(CALUIRE_ET_CUIRE, OTHER)),
    CHECK("Chèque", false, true, true,Arrays.asList(CALUIRE_ET_CUIRE,CLOTHING, FOOD, HEALTH, INCOME_TAXE, LEISURE, MEZIEU, MONTPLAT, NULL, OTHER, PRESENT, STATIONARY, TCL, TELEPHONE_SUBSCRIPTION, TRAVEL)),
    CASH("Liquide", false, false, true, Arrays.asList(CALUIRE_ET_CUIRE,CLOTHING, FOOD, HEALTH, LEISURE, MEZIEU, MONTPLAT, NULL, OTHER, PRESENT, STATIONARY, TRAVEL));

    private @Getter String name;
    private @Getter boolean income;
    private @Getter boolean checkNumberRendered;
    private @Getter boolean themeGeneralRendered;
    private @Getter List<ThemeGeneral> listGenerals;



    private TypeOfTransaction(String name,
                                boolean income,
                                boolean checkNumberRendered,
                                boolean themeGeneralRendered,
                                List<ThemeGeneral> listGenerals){
        this.name= name;
        this.income= income;
        this.checkNumberRendered=checkNumberRendered;
        this.themeGeneralRendered = themeGeneralRendered;
        this.listGenerals = listGenerals;
    }

}
