package br.edu.anhembi.model;

import java.time.LocalDateTime;

public record NotificationRegistrationRequest(
        Long id,
        Integer customerId,
        String customerEmail,
        String message,
        LocalDateTime sentAt) {
}