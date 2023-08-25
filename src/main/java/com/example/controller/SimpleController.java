package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.model.entity.MyRecord;
import com.example.repository.MyRecordRepository;

@Controller
public class SimpleController {
    @Value("${spring.application.name}")
    String appName;
    @Autowired
    private MyRecordRepository repository;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

    @GetMapping("/account-form")
    public String accountForm(Model model) {
        model.addAttribute("appName", appName);
        return "account-form";
    }
}