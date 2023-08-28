package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.enums.TypeOfPayment;

@RestController
@RequestMapping("enummapping")
public class TypeRecordEnumMapingController{
    @GetMapping("/get")
    public String getByLevel(@RequestParam(required = false) TypeOfPayment typeOfPayement){
        return typeOfPayement.name();
    }
}