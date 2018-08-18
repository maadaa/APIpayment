package com.marciodaniel.APIpayment.services.impl;

import com.marciodaniel.APIpayment.domain.Card;
import com.marciodaniel.APIpayment.repositories.CardRepository;
import com.marciodaniel.APIpayment.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card save(Card card) {
        return this.cardRepository.save(card);
    }

    @Override
    public Optional<Card> findByNumber(String number) {
        return this.cardRepository.findByNumber(number);
    }
}
