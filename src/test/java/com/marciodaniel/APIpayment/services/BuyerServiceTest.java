package com.marciodaniel.APIpayment.services;

import com.marciodaniel.APIpayment.domain.Buyer;
import com.marciodaniel.APIpayment.repositories.BuyerRepository;
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

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class BuyerServiceTest {

    @MockBean
    private BuyerRepository buyerRepository;

    @Autowired
    private BuyerService buyerService;

    private static final String CPF = "12343212323";

    private static final long ID = 1L;

    @Before
    public void setUp() {
        BDDMockito.given(this.buyerRepository.save(Mockito.any(Buyer.class))).willReturn(new Buyer());
        BDDMockito.given(this.buyerRepository.findByCpf(Mockito.anyString())).willReturn(Optional.of(new Buyer()));
        BDDMockito.given(this.buyerRepository.findById(Mockito.anyLong())).willReturn(Optional.of(new Buyer()));
    }

    @Test
    public void testPersistirCartao() {
        Buyer buyer = this.buyerService.save(new Buyer());
        Assert.assertNotNull(buyer);
    }

    @Test
    public void testFindByCpf() {
        Optional<Buyer> buyer = this.buyerService.findByCpf(CPF);

        Assert.assertTrue(buyer.isPresent());
    }

    @Test
    public void testFindById() {
        Optional<Buyer> buyer = this.buyerService.findById(ID);

        Assert.assertTrue(buyer.isPresent());
    }
}
