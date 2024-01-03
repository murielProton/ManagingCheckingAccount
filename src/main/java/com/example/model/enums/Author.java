package com.example.model.enums;

import lombok.Getter;

public enum Author {
    BOTH("Les deux"), 
    MURIEL("Muriel"), 
    PATRICK("Patrick");
    
    private @Getter String name;

    private Author(String name){
        this.name= name;
    }
}
