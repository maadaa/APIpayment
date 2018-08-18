package com.marciodaniel.APIpayment.controllers.exceptions;

import org.springframework.validation.BindingResult;

public class BindingResultException extends RuntimeException {

    private final BindingResult bindingResult;

    public BindingResultException(String message, BindingResult bindingResult) {
        super(message);
        this.bindingResult = bindingResult;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }
}
