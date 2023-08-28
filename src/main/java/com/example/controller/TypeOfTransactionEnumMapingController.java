package com.example.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.enums.TypeOfTransaction;

@RestController
@RequestMapping("enummapping")
public class TypeOfTransactionEnumMapingController{

    @GetMapping("/get")
    public String getByLevel(@RequestParam(required = false) TypeOfTransaction typeOfTransaction){
        return typeOfTransaction.name();
    }
}