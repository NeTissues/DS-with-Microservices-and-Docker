package br.edu.anhembi.controller;

import br.edu.anhembi.model.NotificationRegistrationRequest;
import br.edu.anhembi.model.Notifications;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.edu.anhembi.model.repository.NotificationRepository;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/notification")
@AllArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;
    private final NotificationRepository notificationRepository;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRegistrationRequest notificationRequest) {
        //todo: log this
        notificationService.send(notificationRequest);
    }

    @GetMapping
    public List<Notifications> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @GetMapping(path = "{notificationId}")
    public ResponseEntity<Notifications> getNotificationById(@PathVariable(value = "notificationId") Long notificationId) throws NotificationNotFoundException {
        Notifications notifications = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new NotificationNotFoundException(notificationId));
        return ResponseEntity.ok().body(notifications);
    }

    @PutMapping(path = "{notificationId}")
    public ResponseEntity<Notifications> updateNotification(@PathVariable(value = "notificationId") Long notificationId,
                                                            @Valid @RequestBody Notifications notificationDetails) throws NotificationNotFoundException {
        Notifications notifications = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new NotificationNotFoundException(notificationId));

        notifications.setUserId(notificationDetails.getUserId());
        notifications.setUserEmail(notificationDetails.getUserEmail());
        notifications.setMessage(notificationDetails.getMessage());
        notifications.setSentAt(LocalDateTime.now());

        final Notifications updatedNotification = notificationRepository.save(notifications);
        return ResponseEntity.ok(updatedNotification);
    }

    @DeleteMapping(path = "{notificationId}")
    public void deleteNotification(@PathVariable(value = "notificationId") Long notificationId) throws NotificationNotFoundException {
        Notifications notifications = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new NotificationNotFoundException(notificationId));
        notificationRepository.delete(notifications);
    }
}