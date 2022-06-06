package br.edu.anhembi.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderRegistrationRequest(
        BigDecimal totalPrice,
        LocalDateTime date,
        OrderStatus orderStatus,
        Long userId) {
}