package com.marciodaniel.APIpayment.repositories;

import com.marciodaniel.APIpayment.domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {

    @Transactional(readOnly = true)
    Optional<Buyer> findByCpf(String cpf);
}
