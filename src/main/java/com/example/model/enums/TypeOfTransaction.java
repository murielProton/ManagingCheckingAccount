package com.example.model.enums;

import lombok.Getter;

        /** The field 'Check Number' appears if TypeOfTransaction value is CHECK.\
         * **/

public enum TypeOfTransaction {
    SALARY("Salaire", false), 
    PAYMENT("Virement", false), 
    TIP("TIP", false), 
    AUTOMATIC_DRAWDOWN("Prélèvement automatique", false), 
    WITHDRAWAL("Retrait", false), 
    CREDIT_CARD("CB", false), 
    CHECK_CASHING("Encaissement de chèque",false),
    CASHING("Encaissement",false),
    CHECK("Chèque",true), 
    CASH("Liquide",false);

    private @Getter String name;
    private @Getter boolean checkRendered;


    private TypeOfTransaction(String name, boolean checkRendered){
        this.name= name;
        this.checkRendered = checkRendered;
    }

}
