package com.sternitc.urimapper;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class UrlValidator implements ConstraintValidator<ValidUrl, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            System.out.println("About to validate: " + value);
            new URL(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
