package com.marciodaniel.APIpayment.dtos;

import javax.validation.constraints.NotNull;

public class ClientDto {

    @NotNull(message = "Client with ID null")
    private Long id;

    private String socialName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }
}
