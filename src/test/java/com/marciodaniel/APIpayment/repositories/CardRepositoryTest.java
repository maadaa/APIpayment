package com.marciodaniel.APIpayment.repositories;

import com.marciodaniel.APIpayment.domain.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CardRepositoryTest {

    private static final String CARD_NUMBER = "5243673124";

    @Autowired
    private CardRepository cardRepository;

    @Before
    public void testSaveCard() {
        List<Card> cards = new ArrayList<Card>() {{
            add(new Card("BETO SILA", "12312312312", "10/11", 123));
            add(new Card("DANIEL ARMAN", CARD_NUMBER, "12/01", 968));
        }};

        List<Card> cardList = this.cardRepository.saveAll(cards);

        Assert.assertNotNull(cardList);
    }

    @Test
    public void testFindbyNumber() {
        Optional<Card> card = this.cardRepository.findByNumber(CARD_NUMBER);

        Assert.assertTrue(card.isPresent());
    }
}
