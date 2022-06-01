package br.edu.anhembi.model;

import java.time.LocalDateTime;

public record PaymentRegistrationRequest(
        Long id,
         Long orderId,
         Long userId,
         OrderStatus orderStatus,
         String paymentMethod,
         LocalDateTime paymentTime) {
}
