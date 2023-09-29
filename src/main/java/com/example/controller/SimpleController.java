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
        .sorted(Comparator.comparing(Author::getDisplayValue))
        .toList();
        model.addAttribute("authorList",authorList);

        List<ThemeGeneral> themeGeneralList = Arrays.asList(ThemeGeneral.values())
        .stream()
        .sorted(Comparator.comparing(ThemeGeneral::getDisplayValue))
        .toList();
        model.addAttribute("themeGeneralList",themeGeneralList);

        List<ThemeSub> themeSubList = Arrays.asList(ThemeSub.values())
        .stream()
        .sorted(Comparator.comparing(ThemeSub::getDisplayValue))
        .toList();
        model.addAttribute("themeSublList",themeSubList);

        List<TypeOfTransaction> typeOfTransactionList = Arrays.asList(TypeOfTransaction.values())
        .stream()
        .sorted(Comparator.comparing(TypeOfTransaction::getDisplayValue))
        .toList();
        model.addAttribute("typeOfTransactionList",typeOfTransactionList);


        return "/account-form";
    }


    @GetMapping("/all-records")
    public String showAll(Model model) {
        model.addAttribute("myRecords", myRecordRepository.findAll());
        return "/all-records";
    }

    @GetMapping("/all-incomes")
    public String showAllIncomes(Model model) {
        model.addAttribute("myRecords", myRecordRepository.findAllIncomes());
        return "/all-incomes";
    }

    @GetMapping("/business-rules")
    public String showBusinessRules() {
        return "/business-rules";
    }

}