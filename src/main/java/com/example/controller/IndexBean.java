package com.example.controller;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Component
@Named
@ViewScoped
@Slf4j
public class IndexBean implements Serializable {

    private Double input2 = Double.valueOf(0);
    private @Setter @Getter Double input3 = Double.valueOf(14);
    


    
    public Double getInput2() {
        return input2;
    }

    public void setInput2(Double input2) {
        this.input2 = input2;
    }

    @PostConstruct
    public void init(){
        log.info("init 1 input2 -> {} ", input2);
    }

    public void changed(){
        log.info("input2 -> {} ", input2);
        log.info("input3 -> {} ", input3);
        input2++;
    }
}
