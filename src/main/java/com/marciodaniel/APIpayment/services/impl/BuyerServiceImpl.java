package com.marciodaniel.APIpayment.services.impl;

import com.marciodaniel.APIpayment.domain.Buyer;
import com.marciodaniel.APIpayment.repositories.BuyerRepository;
import com.marciodaniel.APIpayment.services.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepository buyerRepository;

    @Autowired
    public BuyerServiceImpl(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @Override
    public Buyer save(Buyer buyer) {
        return this.buyerRepository.save(buyer);
    }

    @Override
    public Optional<Buyer> findById(Long id) {
        return this.buyerRepository.findById(id);
    }

    @Override
    public Optional<Buyer> findByCpf(String cpf) {
        return this.buyerRepository.findByCpf(cpf);
    }
}
