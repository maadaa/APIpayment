package com.marciodaniel.APIpayment.services.impl;

import com.marciodaniel.APIpayment.domain.Client;
import com.marciodaniel.APIpayment.repositories.ClientRepository;
import com.marciodaniel.APIpayment.services.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final Logger logger = LogManager.getLogger(ClientServiceImpl.class);

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {
        logger.info("Save client: " + client.toString());

        return this.clientRepository.save(client);
    }

    @Override
    public Optional<Client> findById(Long id) {
        logger.info("Searching Client By id: " + id);

        return clientRepository.findById(id);
    }

    @Override
    public Optional<Client> findBySocialName(String socialName) {
        logger.info("Searching Client By Social Name: " + socialName);

        return Optional.ofNullable(clientRepository.findBySocialName(socialName));
    }

    @Override
    public List<Client> findAll() {
        logger.info("Listing all clients");

        return this.clientRepository.findAll();
    }
}
