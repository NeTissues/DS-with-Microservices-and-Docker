package br.edu.anhembi.controller;

import br.edu.anhembi.model.Payment;
import br.edu.anhembi.model.PaymentRegistrationRequest;
import br.edu.anhembi.model.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public void registerPayment(PaymentRegistrationRequest paymentRegistrationRequest){
        Payment payment = Payment.builder()
                .orderId(paymentRegistrationRequest.orderId())
                .userId(paymentRegistrationRequest.userId())
                .paymentStatus(paymentRegistrationRequest.paymentStatus())
                .paymentMethod(paymentRegistrationRequest.paymentMethod())
                .paymentTime(LocalDateTime.now())
                .build();
        paymentRepository.saveAndFlush(payment);
    }
}