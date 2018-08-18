package com.marciodaniel.APIpayment.dtos;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class PaymentDto {

    private Long id;

    @NotNull(message = "Payment Amount is null")
    @PositiveOrZero(message = "Amout is negative")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal amount;

    @NotEmpty(message = "Payment Type is empty")
    @NotNull(message = "Payment Type is null")
    private String type;

    private String status;

    @Valid
    private CardDto card;

    private Long boletoNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CardDto getCard() {
        return card;
    }

    public void setCard(CardDto card) {
        this.card = card;
    }

    public Long getBoletoNumber() {
        return boletoNumber;
    }

    public void setBoletoNumber(Long boletoNumber) {
        this.boletoNumber = boletoNumber;
    }
}
