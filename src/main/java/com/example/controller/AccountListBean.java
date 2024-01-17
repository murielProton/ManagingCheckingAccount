package com.example.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.entities.MyRecord;
import com.example.repository.MyRecordRepository;

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
@Getter
@Setter
public class AccountListBean extends UtilsBean  implements Serializable {

    @Autowired
    private MyRecordRepository repository;

    private List<MyRecord> list;
    @PostConstruct
    public void init(){
        list = repository.findAll();
    }
    public void save(){
        list = repository.findAll();
    }

}
