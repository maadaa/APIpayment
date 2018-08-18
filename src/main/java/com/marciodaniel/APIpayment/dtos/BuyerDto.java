package com.marciodaniel.APIpayment.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class BuyerDto {

    @JsonIgnore
    private Long id;

    @NotEmpty(message = "Name is empty of Buyer")
    private String name;

    @NotEmpty(message = "Email is empty of Buyer")
    @Email(message = "Emails is not valid")
    private String email;

    @NotEmpty(message = "CPF is empty of Buyer")
    @CPF(message = "CPF is not valid")
    private String cpf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
