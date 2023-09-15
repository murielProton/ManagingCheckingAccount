package com.example.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.example.model.entities.MyRecord;
import com.example.model.enums.Author;
import com.example.model.enums.ThemeGeneral;
import com.example.model.enums.ThemeSub;
import com.example.model.enums.TypeOfTransaction;
import com.example.repository.MyRecordRepository;


@Controller
public class SimpleController {

    @Autowired
    private MyRecordRepository myRecordRepository;
     
    @GetMapping("/")
    public String viewHomePage() {
        return "home";
    }

    @GetMapping("/account-form")
    public String viewAccountForm(Model model) {
        model.addAttribute("myRecord", new MyRecord());

        // Sort enums when displayed
        List<Author> authorList = Arrays.asList(Author.values())
        .stream()
        .sorted(Comparator.comparing(Author::name))
        .toList();
        model.addAttribute("authorList",authorList);

        List<ThemeGeneral> themeGeneralList = Arrays.asList(ThemeGeneral.values()).stream()
        .sorted(Comparator.comparing(ThemeGeneral::name))
        .toList();
        model.addAttribute("themeGeneralList",themeGeneralList);

        List<ThemeSub> themeSublList = Arrays.asList(ThemeSub.values()).stream()
        .sorted(Comparator.comparing(ThemeSub::name))
        .toList();
        model.addAttribute("themeSublList",themeSublList);

        List<TypeOfTransaction> typeOfTransactionList = Arrays.asList(TypeOfTransaction.values()).stream()
        .sorted(Comparator.comparing(TypeOfTransaction::name))
        .toList();
        model.addAttribute("typeOfTransactionList",typeOfTransactionList);


        return "/account-form";
    }

    @PostMapping("/success")
    public String viewSuccess() {
        
        return "/success";
    }

    @GetMapping("/all-records")
    public String showAll(Model model) {
        model.addAttribute("myRecords", myRecordRepository.findAll());
        return "/all-records";
    }
    @GetMapping("/business-rules")
    public String showBusinessRules() {
        return "/business-rules";
    }

}