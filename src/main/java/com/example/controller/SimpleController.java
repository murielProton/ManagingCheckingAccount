package com.example.controller;

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
        return "/account-form";
    }

    @PostMapping("/process-account-form")
    public String processAccountForm(@Validated MyRecord myRecord, BindingResult result, Model model) {

            //TODO if save OK return sucess page if not return failure page with the correcte message of error.
            myRecordRepository.save(myRecord);

        
        return "success";
    }
    
    @PostMapping("/success")
    public String viewSuccess() {
        
        return "/success";
    }

}