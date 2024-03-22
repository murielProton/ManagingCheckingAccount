package com.example.model.entities;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidationRuleCheckNumberValidator.class)
public @interface ValidationRuleCheckNumber {
    String message() default "Check Number must be filled.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
