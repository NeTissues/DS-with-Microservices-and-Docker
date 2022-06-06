package br.edu.anhembi.model.repository;

import br.edu.anhembi.model.ProductOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrders, Long> {
}
