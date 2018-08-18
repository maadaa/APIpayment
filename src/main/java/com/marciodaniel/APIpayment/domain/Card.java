package com.marciodaniel.APIpayment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "holder_name")
    private String holderName;

    @Column(name = "number")
    private String number;

    @Column(name = "expiration_date")
    private String expirationDate;

    @Column(name = "cvv")
    private int cvv;

    public Card() {

    }

    public Card(String holderName, String number, String expirationDate, int cvv) {
        this.holderName = holderName;
        this.number = number;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", holderName='" + holderName + '\'' +
                ", number='" + number + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", cvv=" + cvv +
                '}';
    }
}
