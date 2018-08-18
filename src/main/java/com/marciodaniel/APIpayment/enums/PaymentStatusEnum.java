package com.marciodaniel.APIpayment.enums;

public enum PaymentStatusEnum {
    WAITING("W"),
    ACCEPTED("A"),
    REFUSED("R");

    private final String value;

    PaymentStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
