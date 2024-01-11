package com.example.model.enums;

import lombok.Getter;

        /** The field 'Check Number' appears if TypeOfTransaction value is CHECK.\
         * **/

public enum TypeOfTransaction {
    SALARY("Salaire", true, false, false),
    PAYMENT("Virement", true, true, false),
    TIP("TIP", false, true, false),
    AUTOMATIC_DRAWDOWN("Prélèvement automatique",false, true, false),
    WITHDRAWAL("Retrait", false, false, false),
    CREDIT_CARD("CB", false, true, false),
    CHECK_CASHING("Encaissement de chèque", true, true, false),
    CASHING("Encaissement", true, true, false),
    CHECK("Chèque", false, true, true),
    CASH("Liquide", false, true, false);

    private @Getter String name;
    private @Getter boolean income;
    private @Getter boolean themeGeneralRendered;
    private @Getter boolean checkNumberRendered;


    private TypeOfTransaction(String name, boolean income, boolean themeGeneralRendered, boolean checkNumberRendered){
        this.name= name;
        this.income= income;
        this.themeGeneralRendered = themeGeneralRendered;
        this.checkNumberRendered=checkNumberRendered;
    }

}
