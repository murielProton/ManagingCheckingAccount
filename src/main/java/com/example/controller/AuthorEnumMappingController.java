package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.enums.Author;

@RestController
@RequestMapping("enummapping")
public class AuthorEnumMappingController {
    @GetMapping("/Author/get")
    public String getByAuthor(@RequestParam(required = false) Author author){
        return author.name();
    }
}
