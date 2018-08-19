package com.marciodaniel.APIpayment.services.impl;

import com.marciodaniel.APIpayment.domain.Buyer;
import com.marciodaniel.APIpayment.repositories.BuyerRepository;
import com.marciodaniel.APIpayment.services.BuyerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuyerServiceImpl implements BuyerService {

    private final Logger logger = LogManager.getLogger(BuyerServiceImpl.class);

    private final BuyerRepository buyerRepository;

    @Autowired
    public BuyerServiceImpl(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @Override
    public Buyer save(Buyer buyer) {
        logger.info("Save Buyer:" + buyer.toString());

        return this.buyerRepository.save(buyer);
    }

    @Override
    public Optional<Buyer> findById(Long id) {
        logger.info("Searching Buyer by id: " + id);

        return this.buyerRepository.findById(id);
    }

    @Override
    public Optional<Buyer> findByCpf(String cpf) {
        logger.info("Searching Buyer by CPF: " + cpf);

        return this.buyerRepository.findByCpf(cpf);
    }
}
