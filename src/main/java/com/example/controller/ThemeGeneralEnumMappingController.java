package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.enums.ThemeGeneral;

@RestController
@RequestMapping("enummapping")
public class ThemeGeneralEnumMappingController {
    @GetMapping("/ThemeGeneral/get")
    public String getByTheme(@RequestParam(required = false) ThemeGeneral themeGeneral){
        return themeGeneral.name();
    }
}