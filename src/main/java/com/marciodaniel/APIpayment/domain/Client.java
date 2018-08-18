package com.marciodaniel.APIpayment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "social_name", nullable = false)
    private String socialName;

    public Client() {

    }

    public Client(Long id) {
        this.id = id;
    }

    public Client(String socialName) {
        this.socialName = socialName;
    }

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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", socialName='" + socialName + '\'' +
                '}';
    }
}
