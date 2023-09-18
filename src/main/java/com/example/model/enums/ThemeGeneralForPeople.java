package com.example.model.enums;

public enum ThemeGeneralForPeople {
    MURIEL("Muriel"), 
    PATRICK("Patrick");

    private final String displayValue;
    
    private ThemeGeneralForPeople(String displayValue) {
        this.displayValue = displayValue;
    }
    
    public String getDisplayValue() {
        return displayValue;
    }
}
