package com.example.customvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//TOOD : https://www.baeldung.com/spring-mvc-custom-validator

public class CheckNumberValidator {
    
    @Override
    public void initialize(CheckNumberConstraint checkNumber) {
    }

    @Override
    public boolean isValid(String checkNumberField, ConstraintValidatorContext constraintValidatorContext) {
        return checkNumberField != null && checkNumberField.matches("[0-9]+") && (checkNumberField.length() > 8) && (checkNumberField.length() < 14);
    }
}
