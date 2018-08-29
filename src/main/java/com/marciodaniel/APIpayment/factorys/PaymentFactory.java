package com.marciodaniel.APIpayment.factorys;

import com.marciodaniel.APIpayment.domain.*;
import com.marciodaniel.APIpayment.dtos.PaymentDto;
import com.marciodaniel.APIpayment.enums.PaymentTypeEnum;

public class PaymentFactory {

    private static volatile PaymentFactory instance;

    private PaymentFactory() {

    }

    public static PaymentFactory getInstance() {
        if (instance == null) {
            synchronized (PaymentFactory.class) {
                if (instance == null) {
                    instance = new PaymentFactory();
                }
            }
        }

        return instance;
    }

    private static Payment create(PaymentTypeEnum paymentType, Card card, Buyer buyer, Client client) {
        if (PaymentTypeEnum.CARD.equals(paymentType)) {
            return new CreditCardPayment(client, buyer, card);
        }

        return new BoletoPayment(client, buyer, card);
    }

    public static Payment create(String type, Card card, Buyer buyer, Client client) {
        if(type != null)
            return create(PaymentTypeEnum.valueOf(type), card, buyer, client);

        return null;
    }

}
