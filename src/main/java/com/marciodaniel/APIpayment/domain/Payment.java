package com.marciodaniel.APIpayment.domain;

import com.marciodaniel.APIpayment.enums.PaymentStatusEnum;
import com.marciodaniel.APIpayment.enums.PaymentTypeEnum;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "payment")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "amount", scale = 2, nullable = false)
    protected BigDecimal amount;

    @Column(name = "boleto_number")
    protected Long boletoNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type", nullable = false)
    protected PaymentTypeEnum paymentType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    protected PaymentStatusEnum paymentStatus;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    protected Client client;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "buyer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    protected Buyer buyer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "card_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    protected Card card;

    public Payment() {

    }

    public Payment(Card card) {
        this.card = card;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentTypeEnum getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypeEnum paymentType) {
        this.paymentType = paymentType;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public abstract void confirmPayment();

    public PaymentStatusEnum getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatusEnum paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getBoletoNumber() {
        return boletoNumber;
    }

    public void setBoletoNumber(Long boletoNumber) {
        this.boletoNumber = boletoNumber;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", amount=" + amount +
                ", boletoNumber=" + boletoNumber +
                ", paymentType=" + paymentType +
                ", paymentStatus=" + paymentStatus +
                ", client=" + client +
                ", buyer=" + buyer +
                ", card=" + card +
                '}';
    }
}
