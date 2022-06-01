package br.edu.anhembi.model;

import java.time.LocalDateTime;

public record NotificationRegistrationRequest(
        Long id,
        Integer userId,
        String userEmail,
        String message,
        LocalDateTime sentAt) {
}