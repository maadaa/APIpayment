package com.marciodaniel.APIpayment;

import com.marciodaniel.APIpayment.domain.Client;
import com.marciodaniel.APIpayment.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ApIpaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApIpaymentApplication.class, args);
	}

	@Bean
    CommandLineRunner init(ClientRepository clientRepository) {
	    return args -> Arrays.asList("NerdGeek CO", "A Loja do Sabre SA", "Gumpa CO")
                .forEach( socialName -> {
                    Client client = new Client(socialName);
                    clientRepository.save(client);
                });
    }
}
