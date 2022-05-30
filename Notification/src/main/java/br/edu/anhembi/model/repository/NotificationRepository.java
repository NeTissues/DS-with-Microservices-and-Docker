package br.edu.anhembi.model.repository;

import br.edu.anhembi.model.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notifications, Integer> {
}
