package com.marciodaniel.APIpayment.controllers;

import com.marciodaniel.APIpayment.dtos.CardDto;
import com.marciodaniel.APIpayment.dtos.PaymentInfoDto;
import com.marciodaniel.APIpayment.enums.PaymentTypeEnum;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class ViewController {

    @GetMapping
    public ModelAndView index() {
        RestTemplate restTemplate = new RestTemplate();

        List clients = restTemplate.getForObject("http://localhost:8080/api/client/all", List.class);

        List payments = restTemplate.getForObject("http://localhost:8080/api/payment/all", List.class);

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("paymentInfo", new PaymentInfoDto());
        modelAndView.addObject("card", new CardDto());
        modelAndView.addObject("clients", clients);
        modelAndView.addObject("payments", payments);

        return modelAndView;
    }

    @PostMapping("save")
    public ModelAndView savePayment(@Valid @ModelAttribute PaymentInfoDto paymentInfoDto, @ModelAttribute CardDto cardDto, BindingResult result, ModelAndView modelAndView, RedirectAttributes redirectAttributes) {
        try {
            modelAndView.setViewName("redirect:/");

            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<CardDto>> validate = null;

            boolean equalsCard = paymentInfoDto.getPayment().getType().equals(PaymentTypeEnum.CARD.getValue());

            if (equalsCard) {
                validate = validator.validate(cardDto);
            }

            if (result.hasErrors() && (validate != null && !validate.isEmpty())) {
                validate.stream().forEach(valid -> result.addError(new ObjectError(valid.getRootBeanClass().getName(), valid.getMessage())));
                redirectAttributes.addFlashAttribute("messageError", result.getFieldErrors().toString());
                return modelAndView;
            } else {

                if (equalsCard) {
                    paymentInfoDto.getPayment().setCard(cardDto);
                }

                RestTemplate restTemplate = new RestTemplate();

                HttpEntity<PaymentInfoDto> request = new HttpEntity<>(paymentInfoDto);

                ResponseEntity<PaymentInfoDto> response = restTemplate.exchange("http://localhost:8080/api/payment/conclude", HttpMethod.POST, request, PaymentInfoDto.class);


                if (response.getStatusCode() == HttpStatus.OK) {
                    PaymentInfoDto payment = response.getBody();

                    if (payment.getPayment().getBoletoNumber() != null) {
                        redirectAttributes.addFlashAttribute("message", "Boleto Number: " + payment.getPayment().getBoletoNumber());
                    } else {
                        redirectAttributes.addFlashAttribute("message", "Insert Success");
                    }
                } else {
                    redirectAttributes.addFlashAttribute("messageError", "API return code: " + response.getStatusCode());
                }
            }

            return modelAndView;
        } catch (Exception e) {
            modelAndView.setViewName("redirect:/");
            redirectAttributes.addFlashAttribute("messageError", "Error on Insert Payment");

            return modelAndView;
        }
    }

    @GetMapping("info/{id}")
    public ModelAndView infoPayment(@PathVariable("id") Long id, ModelAndView modelAndView, RedirectAttributes redirectAttributes) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<PaymentInfoDto> response = restTemplate.getForEntity("http://localhost:8080/api/payment/status?idPayment=" + id, PaymentInfoDto.class);


        if (response.getStatusCode() == HttpStatus.OK) {
            modelAndView.setViewName("details");
            modelAndView.addObject("payment", response.getBody());
        } else {
            modelAndView.setViewName("redirect:/");
            redirectAttributes.addFlashAttribute("messageError", "Payment not Found");
        }

        return modelAndView;
    }

}
