package com.example.model.enums;

import lombok.Getter;

        /** The field 'Check Number' appears if TypeOfTransaction value is CHECK.\
         * **/

public enum TypeOfTransaction {
    SALARY("Salaire"), 
    PAYMENT("Virement"), 
    TIP("TIP"), 
    AUTOMATIC_DRAWDOWN("Prélèvement automatique"), 
    WITHDRAWAL("Retrait"), 
    CREDIT_CARD("CB"), 
    CHECK_CASHING("Encaissement de chèque"),
    CASHING("Encaissement"),
    CHECK("Chèque"), 
    CASH("Liquide");

    private @Getter String name;

    private TypeOfTransaction(String name){
        this.name= name;
    }

}
