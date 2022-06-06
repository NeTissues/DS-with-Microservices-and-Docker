package br.edu.anhembi.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductOrderRegistrationRequest(
        BigDecimal unitPrice,
        int quantity,
        Orders order,
        OrderStatus orderStatus,
        LocalDateTime addedAt) {
}