package com.example.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    private List<MyRecord> list;

    private String display = "none";

    @PostConstruct
    public void init(){
        currentRecord = new MyRecord();
        log.info("init 1 currentRecord -> {} ", currentRecord);
        list = repository.findAll();
    }
    public void save(){
        repository.save(currentRecord);
        // Rechargement de la liste en full
        list = repository.findAll();
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
    public List<ThemeSub> getMatchThemeSub(ThemeGeneral general){
        log.info("Récupération du sous thème pour {}", general);
        return Arrays.asList(ThemeSub.values()).stream()
            .filter(sub -> sub.getListGenerals().contains(general))
            .collect(Collectors.toList());
    }

     public List<Author> getAllAuthor(){
        return Arrays.asList(Author.values());
     }
     public boolean showFieldAuthor(){
        /** The field 'Author' appears if ThemeSub value is in the folowing list : CONSTRUCTION_WORK, COSTS, PROPERTY_TAXES, WATER, GASS, 
         * ELECTRICITY, LOAN, FIRE_WOOD, INSURANCE, BOILER, CHIMNEY_SWEEPING, HOME_APPLIANCE, FURNITURE.\
         * Front style="display: block" or style="display: none"
         * **/
        if(currentRecord.getThemeSub()==null){
            return true;
        }
        return !currentRecord.getThemeSub().isAuthorHide();
     }
}
