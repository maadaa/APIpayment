package com.marciodaniel.APIpayment.services;

import com.marciodaniel.APIpayment.domain.Buyer;

import java.util.Optional;

public interface BuyerService {

    Buyer save(Buyer buyer);

    Optional<Buyer> findById(Long id);

    Optional<Buyer> findByCpf(String cpf);
}
