package com.marciodaniel.APIpayment.services.impl;

import com.marciodaniel.APIpayment.domain.Client;
import com.marciodaniel.APIpayment.repositories.ClientRepository;
import com.marciodaniel.APIpayment.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {
        return this.clientRepository.save(client);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Optional<Client> findBySocialName(String socialName) {
        return Optional.ofNullable(clientRepository.findBySocialName(socialName));
    }

    @Override
    public List<Client> findAll() {
        return this.clientRepository.findAll();
    }
}
