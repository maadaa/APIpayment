package com.marciodaniel.APIpayment.services.impl;

import com.marciodaniel.APIpayment.domain.Buyer;
import com.marciodaniel.APIpayment.domain.Card;
import com.marciodaniel.APIpayment.domain.Payment;
import com.marciodaniel.APIpayment.repositories.PaymentRepository;
import com.marciodaniel.APIpayment.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    private final CardServiceImpl cardService;

    private final ClientServiceImpl clientService;

    private final BuyerServiceImpl buyerService;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, CardServiceImpl cardService, ClientServiceImpl clientService, BuyerServiceImpl buyerService) {
        this.paymentRepository = paymentRepository;
        this.cardService = cardService;
        this.clientService = clientService;
        this.buyerService = buyerService;
    }

    @Override
    public Payment save(Payment payment) {
        Card card = payment.getCard();
        Buyer buyer = payment.getBuyer();

        payment.confirmPayment();

        if (buyer != null) {

            Optional<Buyer> buyerFounded = this.buyerService.findByCpf(buyer.getCpf());

            buyerFounded.ifPresent(buyer_ -> buyer.setId(buyer_.getId()));

            this.buyerService.save(buyer);
        }

        if (card != null) {
            this.cardService.save(card);
        }

        return this.paymentRepository.save(payment);
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return this.paymentRepository.findById(id);
    }

    @Override
    public List<Payment> findAll() {
        return this.paymentRepository.findAll();
    }
}
