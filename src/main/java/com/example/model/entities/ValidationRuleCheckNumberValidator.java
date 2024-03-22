package com.example.model.entities;

import com.example.model.enums.TypeOfTransaction;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidationRuleCheckNumberValidator implements ConstraintValidator<ValidationRuleCheckNumber,MyRecord> {
    @Override
    public void initialize(ValidationRuleCheckNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(MyRecord value, ConstraintValidatorContext context){
        if (value.getTypeTransaction() == TypeOfTransaction.CHECK) {
            // If transaction type is CHECK, check if check number exists
            if (value.getCheckNumber() == null || value.getCheckNumber().isEmpty()) {
                // If check number is missing, return false (invalid)
                return false;
            }
        }
        // For all other transaction types or when check number is provided for CHECK
        // Return true (valid)
        return true;
    }
}
