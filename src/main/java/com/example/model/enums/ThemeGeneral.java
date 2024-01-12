package com.example.model.enums;

import lombok.Getter;

public enum ThemeGeneral {
    NULL("", false),
    CALUIRE_ET_CUIRE("Caluire et Cuire", false), 
    MEZIEU("Meyzieu",false), 
    MONTPLAT("Montplat",false), 
    HEALTH("Santé",true), 
    FOOD("Alimentation",false), 
    LEISURE("Loisir",true), 
    TRAVEL("Voyages",true), 
    TCL("TCL",true), 
    CLOTHING("Vêtement(s)", true), 
    STATIONARY("Papetterie",true), 
    OTHER("Autres",false), 
    PRESENT("Cadeau(x)",true),
    INCOME_TAXE("Impôt sur le revenu",true),
    TELEPHONE_SUBSCRIPTION("Abonnement téléphonique",true);

    private @Getter String name;
    private @Getter boolean beneficiaryRendered;

    private ThemeGeneral(String name,boolean beneficiaryRendered){
        this.name= name;
        this.beneficiaryRendered = beneficiaryRendered;
    }
}
