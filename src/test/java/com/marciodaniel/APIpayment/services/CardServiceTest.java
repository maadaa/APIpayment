package com.marciodaniel.APIpayment.services;

import com.marciodaniel.APIpayment.domain.Card;
import com.marciodaniel.APIpayment.repositories.CardRepository;
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
public class CardServiceTest {

    @MockBean
    private CardRepository cardRepository;

    @Autowired
    private CardService cardService;

    private static final String CARD_NUMBER = "5243673124";

    @Before
    public void setUp() {
        BDDMockito.given(this.cardRepository.save(Mockito.any(Card.class))).willReturn(new Card());
        BDDMockito.given(this.cardRepository.findByNumber(Mockito.anyString())).willReturn(Optional.of(new Card()));
    }

    @Test
    public void testPersistirCartao() {
        Card card = this.cardService.save(new Card());
        Assert.assertNotNull(card);
    }

    @Test
    public void testFindByNumber() {
        Optional<Card> card = this.cardService.findByNumber(CARD_NUMBER);
        Assert.assertTrue(card.isPresent());
    }
}
