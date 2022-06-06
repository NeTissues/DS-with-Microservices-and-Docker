package br.edu.anhembi.model.repository;

import br.edu.anhembi.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
