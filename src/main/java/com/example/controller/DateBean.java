package com.example.controller;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Component
@Named
@ViewScoped
@Slf4j
public class DateBean implements Serializable {

    private LocalDate dateDefaultValue = LocalDate.now();

}
