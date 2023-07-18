package com.sternitc.urimapper;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({FIELD})
@Documented
@Constraint(validatedBy = {UrlValidator.class})
public @interface ValidUrl {
    String message() default "URI is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    // We can have additional members to configure the check.
}
