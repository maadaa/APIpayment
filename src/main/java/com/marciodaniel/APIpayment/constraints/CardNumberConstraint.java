package com.marciodaniel.APIpayment.constraints;

import com.marciodaniel.APIpayment.constraints.validators.CardNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = CardNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CardNumberConstraint {
    String message() default "Invalid Card Number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
