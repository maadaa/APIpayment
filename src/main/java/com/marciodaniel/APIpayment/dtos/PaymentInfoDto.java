package com.marciodaniel.APIpayment.dtos;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class PaymentInfoDto {

    @Valid
    @NotNull(message = "Client is null")
    private ClientDto client;

    @Valid
    @NotNull(message = "Buyer is null")
    private BuyerDto buyer;

    @Valid
    @NotNull(message = "Payment is null")
    private PaymentDto payment;

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public BuyerDto getBuyer() {
        return buyer;
    }

    public void setBuyer(BuyerDto buyer) {
        this.buyer = buyer;
    }

    public PaymentDto getPayment() {
        return payment;
    }

    public void setPayment(PaymentDto payment) {
        this.payment = payment;
    }
}
