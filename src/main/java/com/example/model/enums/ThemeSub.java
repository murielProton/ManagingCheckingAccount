package com.example.model.enums;

import lombok.Getter;

public enum ThemeSub {
    Null(""),
    RENT("Loyer"), 
    CONSTRUCTION_WORK("Travaux"), 
    COSTS("Coût"), 
    PROPERTY_TAXES("Taxe foncière"), 
    WATER("Eau"), 
    GASS("Gaz"), 
    ELECTRICITY("Electircité"), 
    LOAN("Prêt"), 
    FIRE_WOOD("Bois de chauffe"), 
    INSURANCE("Assurance"), 
    BOILER("Chaudière"), 
    CHIMNEY_SWEEPING("Ramonage"), 
    HOME_APPLIANCE("Electroménager"), 
    FURNITURE("Mobilier"), 
    PATRICK("Patrick"), 
    MURIEL("Muriel");

    private @Getter String name;

    private ThemeSub(String name){
        this.name= name;
    }
}
