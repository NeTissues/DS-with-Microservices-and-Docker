package br.edu.anhembi.controller;

import br.edu.anhembi.model.NotificationRegistrationRequest;
import br.edu.anhembi.model.Notifications;
import br.edu.anhembi.model.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void send(NotificationRegistrationRequest notificationRequest) {
        notificationRepository.save(
                Notifications.builder()
                        .toCustomerId(notificationRequest.customerId())
                        .toCustomerEmail(notificationRequest.customerEmail())
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
