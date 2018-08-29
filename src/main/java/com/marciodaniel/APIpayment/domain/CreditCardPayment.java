package com.marciodaniel.APIpayment.domain;

import com.marciodaniel.APIpayment.enums.PaymentStatusEnum;

import javax.persistence.Entity;

@Entity
public class CreditCardPayment extends Payment {

    public CreditCardPayment() {
        super();
    }

    public CreditCardPayment(Client client, Buyer buyer, Card card) {
        super(client, buyer, card);
    }

    @Override
    public void confirmPayment() {
        if (this.amount.longValue() % 2 > 0) {
            this.paymentStatus = PaymentStatusEnum.ACCEPTED;
        } else {
            this.paymentStatus = PaymentStatusEnum.REFUSED;
        }
    }
}
