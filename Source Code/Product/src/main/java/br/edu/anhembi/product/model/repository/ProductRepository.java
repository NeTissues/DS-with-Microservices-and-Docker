package br.edu.anhembi.product.model.repository;

import br.edu.anhembi.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
