package com.example.model.enums;

import lombok.Getter;

public enum ThemeGeneral {
    NULL(""),
    CALUIRE_ET_CUIRE("Caluire et Cuire"), 
    MEZIEU("Meyzieu"), 
    MONTPLAT("Montplat"), 
    HEALTH("Santé"), 
    FOOD("Alimentation"), 
    LEISURE("Loisir"), 
    TRAVEL("Voyages"), 
    TCL("TCL"), 
    CLOTHING("Vêtement(s)"), 
    STATIONARY("Papetterie"), 
    OTHER("Autres"), 
    PRESENT("Cadeau(x)"),
    INCOME_TAXE("Impôt sur le revenu"),
    TELEPHONE_SUBSCRIPTION("Abonnement téléphonique");

    private @Getter String name;

    private ThemeGeneral(String name){
        this.name= name;
    }
}
