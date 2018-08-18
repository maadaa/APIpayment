package com.marciodaniel.APIpayment.services;

import com.marciodaniel.APIpayment.domain.Card;

import java.util.Optional;

public interface CardService {

    Card save(Card card);

    Optional<Card> findByNumber(String number);

}
