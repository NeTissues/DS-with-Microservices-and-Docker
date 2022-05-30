package br.edu.anhembi.product.controller;

import br.edu.anhembi.product.model.Product;
import br.edu.anhembi.product.model.ProductRegistrationRequest;
import br.edu.anhembi.product.model.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public record ProductService(ProductRepository productRepository) {
    public void registerProduct(ProductRegistrationRequest request) {
        Product product = Product.builder()
                .name(request.name())
                .price(Double.parseDouble(request.price()))
                .description(request.description())
                .build();
        // todo: add date of creation for product
        // todo: check if product is not duplicate
        productRepository.save(product);
    }
}
