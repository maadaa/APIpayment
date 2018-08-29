package com.marciodaniel.APIpayment.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marciodaniel.APIpayment.constraints.CardNumberConstraint;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CardDto {

    @JsonIgnore
    private Long id;

    @NotEmpty(message = "Card Holder Name is empty")
    private String holderName;

    @CardNumberConstraint
    @NotEmpty(message = "Card Number is empty")
    private String number;

    @NotEmpty(message = "Expiration Date is empty of Card")
    private String expirationDate;

    @JsonIgnore
    @NotNull(message = "CVV is empty of Card")
    private int cvv;

    public CardDto(Long id, String holderName, String number, String expirationDate, int cvv) {
        this.id = id;
        this.holderName = holderName;
        this.number = number;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
