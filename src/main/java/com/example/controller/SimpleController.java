package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

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
    public String processAccountForm(MyRecord myRecord) {
        
        myRecordRepository.save(myRecord);
        
        return "success";
    }


}