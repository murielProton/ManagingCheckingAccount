package com.example.controller;

import org.springframework.stereotype.Component;

import com.example.model.entities.MyRecord;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Component
@Named
@ViewScoped
@Slf4j
public class  AccountFormBean {
    private MyRecord reccordDefaultValue;
    private @Setter @Getter MyRecord newRecord;

    public void changed(){
        log.info("reccordDefaultValue -> {} ", reccordDefaultValue);
        log.info("newRecord -> {} ", newRecord);
    }
    
}
