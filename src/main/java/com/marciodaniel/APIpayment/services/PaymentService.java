package com.marciodaniel.APIpayment.services;

import com.marciodaniel.APIpayment.domain.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    /**
     * Method responsible for save payment and every business rule
     * @param payment
     * @return
     */
    Payment save(Payment payment);

    Optional<Payment> findById(Long id);

    List<Payment> findAll();
}
