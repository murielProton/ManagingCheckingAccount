package com.example.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.entities.MyRecord;
import com.example.model.enums.Author;
import com.example.model.enums.ThemeGeneral;
import com.example.model.enums.ThemeSub;
import com.example.model.enums.TypeOfTransaction;
import com.example.repository.MyRecordRepository;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Component
@Named
@ViewScoped
@Slf4j
public class AccountFormBean implements Serializable {

    private LocalDate dateDefaultValue = LocalDate.now();
    @Autowired
    private MyRecordRepository repository;

    private MyRecord currentRecord; 

    @PostConstruct
    public void init(){

        //currentRecord = repository.findAll().get(0);
        currentRecord = new MyRecord();
        log.info("init 1 currentRecord -> {} ", currentRecord);
    }
    public void save(){
        repository.save(currentRecord);
    }
    public List<TypeOfTransaction> getAllTypeOfTransaction(){
        return Arrays.asList(TypeOfTransaction.values());
    }
    public List<ThemeGeneral> getAllThemeGeneral(){
        return Arrays.asList(ThemeGeneral.values());
    }
     public List<ThemeSub> getAllThemeSub(){
        return Arrays.asList(ThemeSub.values());
    }

     public List<Author> getAllAuthor(){
        return Arrays.asList(Author.values());
     }
}
