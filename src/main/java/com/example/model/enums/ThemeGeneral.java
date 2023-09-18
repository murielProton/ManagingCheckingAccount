package com.example.model.enums;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

public enum ThemeGeneral {
    CALUIRE_ET_CUIRE("Caluire et Cuire"), 
    MEYZIEU("Meyzieu"), 
    MONTPLAT("Montplat"), 
    HEALTH("Santé"), 
    FOOD("Alimentaire"), 
    LEISURE("Loisirs"), 
    TRAVEL("Voyages"), 
    TCL("TCL"), 
    CLOTHING("Vêtements"), 
    STATIONARY("Papetterie"), 
    OTHER("Autre"), 
    INCOME_TAXE("Impôt sur le revenu"), 
    PRESENT("Cadeau"), 
    COMPUTER("Informatique"), 
    MURIEL("Muriel"), 
    PATRICK("Patrick");
    
    private final String displayValue;
    
    private ThemeGeneral(String displayValue) {
        this.displayValue = displayValue;
    }
    
    public String getDisplayValue() {
        return displayValue;
    }

}
