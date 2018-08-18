package com.marciodaniel.APIpayment.repositories;

import com.marciodaniel.APIpayment.domain.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    private static final String SOCIAL_NAME = "Casa da Coxinha";

    @Before
    public void setUp() throws Exception {
        Client client = new Client();
        client.setSocialName("Casa da Coxinha");
        this.clientRepository.save(client);
    }

    @Test
    public void testeBuscaPorRazaoSocial() {
        Client client = this.clientRepository.findBySocialName(SOCIAL_NAME);

        assertEquals(SOCIAL_NAME, client.getSocialName());
    }

    @After
    public void tearDown() {
        this.clientRepository.deleteAll();
    }
}
