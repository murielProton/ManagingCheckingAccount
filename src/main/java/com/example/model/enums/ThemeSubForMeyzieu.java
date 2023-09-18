package com.example.model.enums;

public enum ThemeSubForMeyzieu {
    CONSTRUCTION_WORK("Travaux"), 
    COSTS("Charges"), 
    PROPERTY_TAXE("Impôt foncier"), 
    HOUSING_TAXE("Taxe d'habitation"), 
    WATER("Eau"), 
    GASS("Gaz"), 
    ELECTRICITY("Electricité"), 
    LOAN("Prêt immobilier"), 
    FIRE_WOOD("Bois de chauffe"), 
    INSURANCE("Assurance"), 
    BOILER("Chaudière"), 
    CHIMNEY_SWEEPING("Ramonage"), 
    HOME_APPLIANCE("Electroménager"), 
    FURNITURE("Mobilier");
    
    private final String displayValue;
    
    private ThemeSubForMeyzieu(String displayValue) {
        this.displayValue = displayValue;
    }
    
    public String getDisplayValue() {
        return displayValue;
    }
}


