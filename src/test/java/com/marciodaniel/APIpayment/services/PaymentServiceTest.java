package com.marciodaniel.APIpayment.services;

import com.marciodaniel.APIpayment.domain.BoletoPayment;
import com.marciodaniel.APIpayment.domain.CreditCardPayment;
import com.marciodaniel.APIpayment.domain.Payment;
import com.marciodaniel.APIpayment.repositories.PaymentRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PaymentServiceTest {

    private static final long ID = 1L;

    @MockBean
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentService paymentService;

    @Before
    public void setUp() {
        BDDMockito.given(this.paymentRepository.save(Mockito.any(CreditCardPayment.class))).willReturn(new CreditCardPayment());
        BDDMockito.given(this.paymentRepository.save(Mockito.any(BoletoPayment.class))).willReturn(new BoletoPayment());
        BDDMockito.given(this.paymentRepository.findById(Mockito.anyLong())).willReturn(Optional.of(new CreditCardPayment()));
        BDDMockito.given(this.paymentRepository.findAll()).willReturn(new ArrayList<>());
    }

    @Test
    public void testPersistirCartaoDeCredito() {
        CreditCardPayment creditCardPayment = new CreditCardPayment();
        creditCardPayment.setAmount(new BigDecimal(23.49).setScale(2, BigDecimal.ROUND_HALF_UP));

        Payment payment = this.paymentService.save(creditCardPayment);

        Assert.assertNotNull(payment);
    }

    @Test
    public void testPersistirBoleto() {
        Payment payment = this.paymentService.save(new BoletoPayment());

        Assert.assertNotNull(payment);
    }

    @Test
    public void testFindById() {
        Optional<Payment> payment = this.paymentService.findById(ID);
        Assert.assertTrue(payment.isPresent());
    }

    @Test
    public void testFindAll() {
        List<Payment> payments = this.paymentService.findAll();
        Assert.assertNotNull(payments);
    }
}
