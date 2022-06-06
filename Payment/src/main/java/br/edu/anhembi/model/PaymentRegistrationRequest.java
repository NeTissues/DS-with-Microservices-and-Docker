package br.edu.anhembi.model;

import java.time.LocalDateTime;

public record PaymentRegistrationRequest(
        Long id,
        Long orderId,
        Long userId,
        PaymentStatus paymentStatus,
        String paymentMethod,
        LocalDateTime paymentTime) {
}
