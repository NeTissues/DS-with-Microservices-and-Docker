package br.edu.anhembi.model.repository;

import br.edu.anhembi.model.OrderStatus;
import br.edu.anhembi.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    Optional<Orders> findTopByUserIdAndOrderStatus(Long userId, OrderStatus orderStatus);
}
