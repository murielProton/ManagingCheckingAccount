package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.repository.MyRecordRepository;


@Controller
public class SimpleController {

    @Autowired
    private MyRecordRepository myRecordRepository;
     
    @GetMapping("/")
    public String viewHomePage() {
        return "home";
    }



}