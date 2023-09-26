package com.example.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.entities.MyRecord;

//TOOD : https://www.baeldung.com/spring-mvc-custom-validator
@Controller
public class CheckNumberValidationController {

    @GetMapping("/validateCheckNumber")
    public String loadFormPage(Model model) {
        model.addAttribute("validatedCheckNumber", new MyRecord()));
        return "account-form";
    }
    
    @PostMapping("/addValidateCheckNumber")
    public String submitForm(@Validated MyRecord validatedMyRecord,
      BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "account-form";
        }
        model.addAttribute("message", "Successfully check number : "
          + validatedMyRecord.toString());
        return "account-form";
    }   

}