package com.marciodaniel.APIpayment.controllers;

import com.marciodaniel.APIpayment.domain.Client;
import com.marciodaniel.APIpayment.dtos.ClientDto;
import com.marciodaniel.APIpayment.services.impl.ClientServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/client")
@CrossOrigin("*")
public class ClientController {

    private final Logger logger = LogManager.getLogger(ClientController.class);

    private final ClientServiceImpl clientService;

    @Autowired
    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientDto>> findAll() {
        logger.info("List All Clients");

        List<Client> clients = this.clientService.findAll();

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(this.convertToDto(clients));
    }

    private List<ClientDto> convertToDto(List<Client> clients) {
        List<ClientDto> clientsDto = new ArrayList<>();

        clients.forEach(client -> {
            ClientDto clientDto = new ClientDto();
            clientDto.setId(client.getId());
            clientDto.setSocialName(client.getSocialName());

            clientsDto.add(clientDto);
        });

        return clientsDto;
    }
}
