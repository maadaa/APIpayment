package com.marciodaniel.APIpayment.repositories;

import com.marciodaniel.APIpayment.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {

    @Transactional(readOnly = true)
    Optional<Card> findByNumber(String number);

}
