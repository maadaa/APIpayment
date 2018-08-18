package com.marciodaniel.APIpayment.enums;

public enum PaymentTypeEnum {
    BOLETO("BB"),
    CARD("CC");

    private final String value;

    PaymentTypeEnum(String value) {
        this.value = value;
    }

    public static PaymentTypeEnum byValue(String type) {
        if (BOLETO.getValue().equals(type)) {
            return BOLETO;
        } else if (CARD.getValue().equals(type)) {
            return CARD;
        }

        return null;
    }

    public String getValue() {
        return this.value;
    }

    public boolean equals(PaymentTypeEnum paymentTypeEnum) {
        boolean trueOrFalse = false;
        if (BOLETO.getValue().equals(paymentTypeEnum.getValue()) || CARD.getValue().equals(paymentTypeEnum.getValue())) {
            trueOrFalse = true;
        } 

        return trueOrFalse;
    }

    public boolean equals(String type) {
        boolean trueOrFalse = false;
        if (BOLETO.getValue().equals(type) || CARD.getValue().equals(type)) {
            trueOrFalse = true;
        }

        return trueOrFalse;
    }
}
