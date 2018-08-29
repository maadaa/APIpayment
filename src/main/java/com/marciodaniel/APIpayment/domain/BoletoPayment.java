package com.marciodaniel.APIpayment.domain;

import com.marciodaniel.APIpayment.enums.PaymentStatusEnum;

import javax.persistence.Entity;

@Entity
public class BoletoPayment extends Payment {

    public BoletoPayment() {
        super();
    }

    public BoletoPayment(Client client, Buyer buyer, Card card) {
        super(client, buyer, card);
    }

    @Override
    public void confirmPayment() {
        this.boletoNumber = ((Double) (Math.random() * (Math.pow(10, 10)))).longValue();
        this.paymentStatus = PaymentStatusEnum.WAITING;
    }
}
