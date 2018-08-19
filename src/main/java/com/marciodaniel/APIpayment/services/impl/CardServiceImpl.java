package com.marciodaniel.APIpayment.services.impl;

import com.marciodaniel.APIpayment.domain.Card;
import com.marciodaniel.APIpayment.repositories.CardRepository;
import com.marciodaniel.APIpayment.services.CardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    private final Logger logger = LogManager.getLogger(CardServiceImpl.class);

    private final CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card save(Card card) {
        logger.info("Save Card: " + card.toString());

        return this.cardRepository.save(card);
    }

    @Override
    public Optional<Card> findByNumber(String number) {
        logger.info("Searching Card by Number: " + number);

        return this.cardRepository.findByNumber(number);
    }
}
