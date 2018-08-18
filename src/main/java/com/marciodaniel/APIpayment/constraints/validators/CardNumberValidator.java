package com.marciodaniel.APIpayment.constraints.validators;

import com.marciodaniel.APIpayment.constraints.CardNumberConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CardNumberValidator implements ConstraintValidator<CardNumberConstraint, String> {
    @Override
    public void initialize(CardNumberConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        int[] ints = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ints[i] = Integer.parseInt(s.substring(i, i + 1));
        }
        for (int i = ints.length - 2; i >= 0; i = i - 2) {
            int j = ints[i];
            j = j * 2;
            if (j > 9) {
                j = j % 10 + 1;
            }
            ints[i] = j;
        }
        int sum = 0;
        for (int anInt : ints) {
            sum += anInt;
        }

        boolean result = false;

        if (sum % 10 == 0) {
            result = true;
        }

        return result;
    }
}
