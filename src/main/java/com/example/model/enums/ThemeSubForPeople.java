package com.example.model.enums;

public enum ThemeSubForPeople {
    BOTH("les deux"), 
    HOUSE_HOLD("Foyer"), 
    MURIEL("Muriel"), 
    PATRICK("Patrick");

    private final String displayValue;
    
    private ThemeSubForPeople(String displayValue) {
        this.displayValue = displayValue;
    }
    
    public String getDisplayValue() {
        return displayValue;
    }
}
