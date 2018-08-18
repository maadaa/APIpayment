package com.marciodaniel.APIpayment.factorys;

import com.marciodaniel.APIpayment.domain.BoletoPayment;
import com.marciodaniel.APIpayment.domain.Card;
import com.marciodaniel.APIpayment.domain.CreditCardPayment;
import com.marciodaniel.APIpayment.domain.Payment;
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

    public static Payment create(PaymentTypeEnum paymentType) {
        if (paymentType != null) {
            switch (paymentType) {
                case CARD:
                    return new CreditCardPayment();
                case BOLETO:
                    return new BoletoPayment();
                default:
                    break;
            }
        }

        return null;
    }

    public static Payment create(String type) {
        if (type != null) {
            PaymentTypeEnum paymentTypeEnum = PaymentTypeEnum.valueOf(type);
            switch (paymentTypeEnum) {
                case BOLETO:
                    return new BoletoPayment();
                case CARD:
                    return new CreditCardPayment();
                default:
                    break;
            }
        }

        return null;
    }

    public static Payment create(PaymentDto paymentDto, Card card) {
        String type = paymentDto.getType();
        if (type != null) {
            PaymentTypeEnum paymentTypeEnum = PaymentTypeEnum.byValue(type);
            switch (paymentTypeEnum) {
                case BOLETO:
                    return new BoletoPayment();
                case CARD:
                    return new CreditCardPayment(card);
                default:
                    break;
            }
        }

        return null;
    }

}
