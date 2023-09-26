package com.example.customvalidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//TOOD : https://www.baeldung.com/spring-mvc-custom-validator
//TODO : https://stackoverflow.com/questions/9284450/jsr-303-validation-if-one-field-equals-something-then-these-other-fields-sho
@Target({TYPE, ANNOTATION_TYPE})
@Documented
@Constraint(validatedBy = CheckNumberValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)

public @interface CheckNumberConstraint {
    
    String message() default "When 'Type Of Transaction' is a 'Check' then a check number is required.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
