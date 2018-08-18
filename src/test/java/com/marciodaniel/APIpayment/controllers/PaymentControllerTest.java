package com.marciodaniel.APIpayment.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marciodaniel.APIpayment.domain.Client;
import com.marciodaniel.APIpayment.dtos.BuyerDto;
import com.marciodaniel.APIpayment.dtos.CardDto;
import com.marciodaniel.APIpayment.dtos.ClientDto;
import com.marciodaniel.APIpayment.dtos.PaymentDto;
import com.marciodaniel.APIpayment.dtos.PaymentInfoDto;
import com.marciodaniel.APIpayment.enums.PaymentTypeEnum;
import com.marciodaniel.APIpayment.repositories.ClientRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@WebAppConfiguration
public class PaymentControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ClientRepository clientRepository;

    private Client client;

    private Long idPayment;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        this.client = this.clientRepository.save(new Client("Geek Coisas"));
    }

    @Test
    public void testSavePayment() throws Exception {

        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());

        BuyerDto buyerDto = new BuyerDto();
        buyerDto.setName("Beto Silva");
        buyerDto.setCpf("43869117826");
        buyerDto.setEmail("beto@gmail.com");

        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setType(PaymentTypeEnum.BOLETO.getValue());
        paymentDto.setAmount(new BigDecimal(78.99).setScale(2, BigDecimal.ROUND_HALF_UP));

        PaymentInfoDto paymentInfoDto = new PaymentInfoDto();
        paymentInfoDto.setClient(clientDto);
        paymentInfoDto.setBuyer(buyerDto);
        paymentInfoDto.setPayment(paymentDto);

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/payment/conclude")
                .contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(paymentInfoDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testListAllPayments() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testFindPaymenyById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/status")
                .param("idPayment", String.valueOf(1)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testFindPaymenyByIdNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/payment/status")
                .param("idPayment", String.valueOf(45)))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
