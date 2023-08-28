package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.enums.ThemeGeneral;
import com.example.model.enums.ThemeSub;

@RestController
@RequestMapping("enummapping")
public class ThemeSubEnumMappingController {
    @GetMapping("/ThemeSub/get")
    public String getByTheme(@RequestParam(required = false) ThemeSub themeSub){
        return themeSub.name();
    }
}
