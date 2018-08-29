package com.marciodaniel.APIpayment.dtos;

import com.marciodaniel.APIpayment.domain.Buyer;
import com.marciodaniel.APIpayment.domain.Card;
import com.marciodaniel.APIpayment.domain.Client;
import com.marciodaniel.APIpayment.domain.Payment;
import com.marciodaniel.APIpayment.factorys.PaymentFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class PaymentInfoDto {

    @Valid
    @NotNull(message = "Client is null")
    private Client client;

    @Valid
    @NotNull(message = "Buyer is null")
    private Buyer buyer;

    @Valid
    @NotNull(message = "Payment is null")
    private PaymentDto payment;

    public PaymentInfoDto(Client client, Buyer buyer, PaymentDto payment) {
        this.client = client;
        this.buyer = buyer;
        this.payment = payment;
    }

    public Client getClient() {
        return client;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public PaymentDto getPayment() {
        return payment;
    }

    public void setPayment(PaymentDto payment) {
        this.payment = payment;
    }

    public Payment paymentFor() {
        Card card = null;
        if (payment.getCard() != null) {
            card = new Card(payment.getCard().getHolderName(), payment.getCard().getNumber(), payment.getCard().getExpirationDate(), payment.getCard().getCvv());
        }

        return PaymentFactory.create(payment.getType(), card, buyer, client);
    }

    public static PaymentInfoDto paymentInfoDtoFor(Payment payment) {
        CardDto card = null;
        if (payment.getCard() != null)
               card = new CardDto(payment.getCard().getId() , payment.getCard().getHolderName(), payment.getCard().getNumber(), payment.getCard().getExpirationDate(), payment.getCard().getCvv());

        PaymentDto paymentDto = new PaymentDto(payment.getId(), payment.getAmount(), payment.getPaymentType().getValue(), payment.getPaymentStatus().getValue(), card, payment.getBoletoNumber());

        return new PaymentInfoDto(payment.getClient(), payment.getBuyer(), paymentDto);
    }
}
