package com.example.model.enums;

public enum ThemeSub {

    BOTH("les deux"), 
    HOUSEHOLD("Foyer"), 
    RENT("Loyer"), 
    CONSTRUCTION_WORK("Travaux"), 
    COSTS("Charges"), 
    PROPERTY_TAXE("Impôt foncier"), 
    HOUSING_TAXE("Taxe d'habitation"), 
    WATER("Eau"), 
    GASS("Gaz"), 
    ELECTRICITY("Electricité"), 
    LOAN("Emprun"), 
    FIRE_WOOD("Bois de chauffe"), 
    INSURANCE("Assurance"), 
    BOILER("Chaudière"), 
    CHIMNEY_SWEEPING("Ramonage"), 
    HOME_APPLIANCE("Electroménager"), 
    FURNITURE("Mobilier"), 
    PATRICK("Patrick"), 
    MURIEL("Muriel");
    
    private final String displayValue;
    
    private ThemeSub(String displayValue) {
        this.displayValue = displayValue;
    }
    
    public String getDisplayValue() {
        return displayValue;
    }
}
