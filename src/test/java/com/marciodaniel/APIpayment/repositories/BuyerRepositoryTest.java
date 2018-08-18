package com.marciodaniel.APIpayment.repositories;

import com.marciodaniel.APIpayment.domain.Buyer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class BuyerRepositoryTest {

    private static final String CPF = "12343212323";

    @Autowired
    private BuyerRepository buyerRepository;
    
    @Test
    public void testPersistBuyer() {
        Buyer buyer = this.buyerRepository.save(new Buyer("Beto Silva", "beto@gmail.com", CPF));

        Assert.assertNotNull(buyer);
    }

    @Test
    public void testFindByCpf() {
        Optional<Buyer> buyer = this.buyerRepository.findByCpf(CPF);

        Assert.assertTrue(buyer.isPresent());
    }
}
