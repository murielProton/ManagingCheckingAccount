package com.example.model.enums;

public enum ThemeSubForCaluireEtCuire {
    RENT("Loyer"), 
    CONSTRUCTION_WORK("Travaux"), 
    COSTS("Charges"), 
    PROPERTY_TAXE("Impôt foncier"), 
    HOUSING_TAXE("Taxe d'habitation"), 
    WATER("Eau"), 
    GASS("Gaz"), 
    ELECTRICITY("Electricité"), 
    INSURANCE("Assurance"), 
    BOILER("Chaudière"), 
    HOME_APPLIANCE("Electroménager");
    
    private final String displayValue;
    
    private ThemeSubForCaluireEtCuire(String displayValue) {
        this.displayValue = displayValue;
    }
    
    public String getDisplayValue() {
        return displayValue;
    }
}
