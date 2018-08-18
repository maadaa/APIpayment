package com.marciodaniel.APIpayment.services;

import com.marciodaniel.APIpayment.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    Client save(Client client);

    Optional<Client> findById(Long id);

    Optional<Client> findBySocialName(String socialName);

    List<Client> findAll();
}
