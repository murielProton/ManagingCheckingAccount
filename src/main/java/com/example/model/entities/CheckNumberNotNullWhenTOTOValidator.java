package com.example.model.entities;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckNumberNotNullWhenTOTOValidator implements ConstraintValidator<CheckNumberNotNullWhenTOTO,MyRecord> {
    
    @Override
    public void initialize(CheckNumberNotNullWhenTOTO constraintAnnotation) {
    }

    @Override
    public boolean isValid(MyRecord value, ConstraintValidatorContext context){
        return false;
    }
}
