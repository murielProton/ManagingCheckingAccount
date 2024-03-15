package com.example.model.enums;

import lombok.Getter;

public enum BankAccount {
    JOINT("compte joint"), 
    MURIEL_CURRENT_ACCOUNT("compte courant de Muriel"),
    MURIEL_SAVING_ACCOUNT("compte épargne de Muriel"), 
    PATRICK_CURRENT_ACCOUNT("compte courant de Patrick");
    
    private @Getter String name;

    private BankAccount(String name){
        this.name= name;
    }
}
