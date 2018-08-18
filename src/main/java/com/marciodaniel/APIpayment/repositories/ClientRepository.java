package com.marciodaniel.APIpayment.repositories;

import com.marciodaniel.APIpayment.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Transactional(readOnly = true)
    Client findBySocialName(String socialName);
}
