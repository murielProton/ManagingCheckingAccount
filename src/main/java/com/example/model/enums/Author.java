package com.example.model.enums;

public enum Author {
    BOTH("les deux"), 
    MURIEL("Muriel"), 
    PATRICK("Patrick");

    private final String displayValue;
    
    private Author(String displayValue) {
        this.displayValue = displayValue;
    }
    
    public String getDisplayValue() {
        return displayValue;
    }

}
