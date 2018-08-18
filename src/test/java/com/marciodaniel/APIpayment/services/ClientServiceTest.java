package com.marciodaniel.APIpayment.services;

import com.marciodaniel.APIpayment.domain.Client;
import com.marciodaniel.APIpayment.repositories.ClientRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ClientServiceTest {

    private static final long ID = 1L;

    @MockBean
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    private static final String SOCIAL_NAME = "Casa da Coxinha";

    @Before
    public void setUp() {
        BDDMockito.given(this.clientRepository.findBySocialName(Mockito.anyString())).willReturn(new Client());
        BDDMockito.given(this.clientRepository.save(Mockito.any(Client.class))).willReturn(new Client());
        BDDMockito.given(this.clientRepository.findById(Mockito.anyLong())).willReturn(Optional.of(new Client()));
        BDDMockito.given(this.clientRepository.findAll()).willReturn(new ArrayList<>());
    }

    @Test
    public void testFindBySocialName() {
        Optional<Client> client = this.clientService.findBySocialName(SOCIAL_NAME);

        Assert.assertTrue(client.isPresent());
    }

    @Test
    public void testSaveClient() {
        Client client = this.clientService.save(new Client());
        Assert.assertNotNull(client);
    }

    @Test
    public void testFindById() {
        Optional<Client> client = this.clientService.findById(ID);
        Assert.assertTrue(client.isPresent());
    }

    @Test
    public void testFindAll() {
        List<Client> clients = this.clientService.findAll();
        Assert.assertNotNull(clients);
    }
}
