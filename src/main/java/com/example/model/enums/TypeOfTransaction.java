package com.example.model.enums;

public enum TypeOfTransaction {
    SALARY("Salaire"), 
    PAYMENT("Payement"), 
    TIP("TIP"), 
    AUTOMATIC_DRAWDOWN("Prélèvement automatique"), 
    WITHDRAWAL("Retrait"), 
    CREDIT_CARD("CB"), 
    CHECK_CASHING("Encaissement de chèque"), 
    CASHING("Espèces"), 
    CHECK("Chèque"), 
    CASH("Monnaie");

    private final String displayValue;
    
    private TypeOfTransaction(String displayValue) {
        this.displayValue = displayValue;
    }
    
    public String getDisplayValue() {
        return displayValue;
    }
}
