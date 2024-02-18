package com.example.ForexApp_v1.logic;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TransacListValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface TransacDTOConstraint {
    String message() default "Nieprawidłowa lista transakcji";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}