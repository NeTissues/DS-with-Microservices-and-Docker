package br.edu.anhembi.model.repository;

import br.edu.anhembi.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
